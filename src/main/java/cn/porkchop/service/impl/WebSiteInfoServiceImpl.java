package cn.porkchop.service.impl;

import cn.porkchop.StartUpRunner;
import cn.porkchop.dao.WebSiteInfoRepository;
import cn.porkchop.pojo.WebSiteInfo;
import cn.porkchop.service.WebSiteInfoService;
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
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class WebSiteInfoServiceImpl implements WebSiteInfoService {
    @Autowired
    private WebSiteInfoRepository webSiteInfoRepository;
    @Autowired
    private StartUpRunner startUpRunner;

    @Override
    @Transactional(readOnly = true)
    public EasyUIDatagrid<WebSiteInfo> findByPagination(WebSiteInfo webSiteInfo, Integer page, Integer rows) {
        Specification<WebSiteInfo> specification = new Specification<WebSiteInfo>() {

            @Override
            public Predicate toPredicate(Root<WebSiteInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                if (webSiteInfo != null) {
                    if (StringUtils.isNotBlank(webSiteInfo.getInfo())) {
                        predicate.getExpressions().add(cb.like(root.get("info"), "%" + webSiteInfo.getInfo().trim() + "%"));
                    }
                }
                return predicate;
            }
        };
        PageRequest pageRequest = new PageRequest(page - 1, rows, Sort.Direction.DESC, "publishDate");
        Page<WebSiteInfo> p = webSiteInfoRepository.findAll(specification, pageRequest);
        return new EasyUIDatagrid<WebSiteInfo>(p.getTotalElements(), p.getContent());
    }

    @Override
    public void save(WebSiteInfo webSiteInfo) {
        webSiteInfo.setPublishDate(new Date());
        webSiteInfoRepository.save(webSiteInfo);
        //重新缓存数据
        startUpRunner.loadData();
    }


    @Override
    public void delete(String ids) {
        for (String id : ids.split(",")) {
            webSiteInfoRepository.delete(Integer.valueOf(id));
        }
        //重新缓存数据
        startUpRunner.loadData();
    }

    @Override
    public List<WebSiteInfo> getByFilmId(Integer id) {
        return webSiteInfoRepository.getByFilmId(id);
    }
}
