package cn.porkchop.service.impl;

import cn.porkchop.StartUpRunner;
import cn.porkchop.dao.WebSiteRepository;
import cn.porkchop.pojo.WebSite;
import cn.porkchop.service.WebSiteService;
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
import java.util.List;

@Service
@Transactional
public class WebSiteServiceImpl implements WebSiteService {
    @Autowired
    private WebSiteRepository webSiteRepository;
    @Autowired
    private StartUpRunner startUpRunner;

    @Override
    @Transactional(readOnly = true)
    public EasyUIDatagrid<WebSite> findByPagination(WebSite webSite, Integer page, Integer rows) {
        Specification<WebSite> specification = new Specification<WebSite>() {

            @Override
            public Predicate toPredicate(Root<WebSite> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if (webSite != null) {
                    if (StringUtils.isNotBlank(webSite.getName())) {
                        predicate.getExpressions().add(cb.like(root.get("name"), "%" + webSite.getName().trim() + "%"));
                    }
                    if (StringUtils.isNotBlank(webSite.getUrl())) {
                        predicate.getExpressions().add(cb.like(root.get("url"), "%" + webSite.getUrl().trim() + "%"));
                    }
                }
                return predicate;
            }
        };
        PageRequest pageRequest = new PageRequest(page - 1, rows, Sort.Direction.ASC, "id");
        Page<WebSite> p = webSiteRepository.findAll(specification, pageRequest);
        return new EasyUIDatagrid<WebSite>(p.getTotalElements(), p.getContent());
    }

    @Override
    public void save(WebSite webSite) {
        webSiteRepository.save(webSite);
        //重新缓存数据
        startUpRunner.loadData();
    }


    @Override
    public void delete(String ids) {
        for (String id : ids.split(",")) {
            webSiteRepository.delete(Integer.valueOf(id));
        }
        //重新缓存数据
        startUpRunner.loadData();
    }

    @Override
    @Transactional(readOnly = true)
    public List<WebSite> findAll(String q) {
        Specification<WebSite> specification = new Specification<WebSite>() {

            @Override
            public Predicate toPredicate(Root<WebSite> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if (StringUtils.isNotBlank(q)) {
                    predicate.getExpressions().add(cb.like(root.get("url"), "%" + q + "%"));
                }
                return predicate;
            }
        };
        return webSiteRepository.findAll(specification);
    }
}
