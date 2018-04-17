package cn.porkchop.controller.admin;

import cn.porkchop.pojo.WebSiteInfo;
import cn.porkchop.service.WebSiteInfoService;
import cn.porkchop.utils.EasyUIDatagrid;
import cn.porkchop.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/websiteinfo")
public class WebSiteInfoAdminController {
    @Autowired
    private WebSiteInfoService webSiteInfoService;

    /**
     * 根据条件查询所有
     *
     * @date 2018/4/7 17:13
     * @author porkchop
     */
    @RequestMapping("/findByPaginationWithConditions")
    public EasyUIDatagrid<WebSiteInfo> findByPaginationWithConditions(WebSiteInfo webSiteInfo, Integer page, Integer rows) {
        return webSiteInfoService.findByPagination(webSiteInfo, page, rows);
    }

    /**
     * 更新或添加
     *
     * @date 2018/4/7 18:53
     * @author porkchop
     */
    @RequestMapping("/save")
    public ResponseResult save(WebSiteInfo webSiteInfo) {
        webSiteInfoService.save(webSiteInfo);
        return ResponseResult.success();
    }


    /**
     * 删除
     *
     * @date 2018/4/7 18:56
     * @author porkchop
     */
    @RequestMapping("/delete")
    public ResponseResult delete(String ids) {
        webSiteInfoService.delete(ids);
        return ResponseResult.success();
    }
}
