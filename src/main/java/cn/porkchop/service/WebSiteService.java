package cn.porkchop.service;

import cn.porkchop.pojo.WebSite;
import cn.porkchop.utils.EasyUIDatagrid;

import java.util.List;

public interface WebSiteService {
    /**
     * 根据条件查询所有
     *
     * @date 2018/4/7 17:13
     * @author porkchop
     */
    EasyUIDatagrid<WebSite> findByPagination(WebSite webSite, Integer page, Integer rows);

    /**
     * 更新或添加
     *
     * @date 2018/4/7 18:53
     * @author porkchop
     */
    void save(WebSite webSite);


    /**
     * 删除
     *
     * @param ids
     * @date 2018/4/7 18:56
     * @author porkchop
     */
    void delete(String ids);

    /**
     * 查询所有
     *
     * @date 2018/4/10 12:09
     * @author porkchop
     */
    List<WebSite> findAll(String q);
}
