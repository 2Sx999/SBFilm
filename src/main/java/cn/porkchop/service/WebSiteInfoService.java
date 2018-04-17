package cn.porkchop.service;

import cn.porkchop.pojo.WebSiteInfo;
import cn.porkchop.utils.EasyUIDatagrid;

import java.util.List;

public interface WebSiteInfoService {
    /**
     * 根据条件查询所有
     *
     * @date 2018/4/7 17:13
     * @author porkchop
     */
    EasyUIDatagrid<WebSiteInfo> findByPagination(WebSiteInfo webSiteInfo, Integer page, Integer rows);

    /**
     * 更新或添加
     *
     * @date 2018/4/7 18:53
     * @author porkchop
     */
    void save(WebSiteInfo webSiteInfo);


    /**
     * 删除
     *
     * @date 2018/4/7 18:56
     * @author porkchop
     */
    void delete(String ids);

    /**
     * 根据电影id查询
     *
     * @date 2018/4/16 17:47
     * @author porkchop
     */
    List<WebSiteInfo> getByFilmId(Integer id);
}
