package cn.porkchop.service.impl;

import cn.porkchop.StartUpRunner;
import cn.porkchop.dao.FilmRepository;
import cn.porkchop.pojo.Film;
import cn.porkchop.service.FilmService;
import cn.porkchop.utils.EasyUIDatagrid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private StartUpRunner startUpRunner;

    @Override
    public void save(Film film) {
        film.setPublishDate(new Timestamp(new Date().getTime()));
        filmRepository.save(film);
        //重新缓存数据
        startUpRunner.loadData();
    }

    @Override
    @Transactional(readOnly = true)
    public EasyUIDatagrid<Film> findByPagination(Film film, Integer page, Integer rows) {
        Specification<Film> specification = new Specification<Film>() {

            @Override
            public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if (film != null) {
                    if (StringUtils.isNotBlank(film.getName())) {
                        predicate.getExpressions().add(cb.like(root.get("name"), "%" + film.getName().trim() + "%"));
                    }
                    if (film.getHot() != null) {
                        predicate.getExpressions().add(cb.equal(root.get("hot"), film.getHot()));
                    }
                }
                return predicate;
            }
        };
        PageRequest pageRequest = new PageRequest(page - 1, rows, Sort.Direction.DESC, "publishDate");
        Page<Film> p = filmRepository.findAll(specification, pageRequest);
        return new EasyUIDatagrid<Film>(p.getTotalElements(), p.getContent());
    }

    @Override
    public void delete(String ids) {
        for (String id : ids.split(",")) {
            filmRepository.delete(Integer.valueOf(id));
        }
        //重新缓存数据
        startUpRunner.loadData();
    }

    @Override
    @Transactional(readOnly = true)
    public Film findById(Integer id) {
        return filmRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Film> findAll(String q) {
        Specification<Film> specification = new Specification<Film>() {

            @Override
            public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if (StringUtils.isNotBlank(q)) {
                    predicate.getExpressions().add(cb.like(root.get("name"), "%" + q + "%"));
                }
                return predicate;
            }
        };
        return filmRepository.findAll(specification);
    }

    @Override
    public Film getPrevious(Integer id) {
        return filmRepository.getPrevious(id);
    }


    @Override
    public Film getNext(Integer id) {
        return filmRepository.getNext(id);
    }

    @Override
    public List<Film> getRandomList(int i) {
        return filmRepository.getRandomList(i);
    }
}
