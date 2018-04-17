package cn.porkchop.controller.admin;

import cn.porkchop.pojo.WebSite;
import cn.porkchop.service.WebSiteService;
import cn.porkchop.utils.EasyUIDatagrid;
import cn.porkchop.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/website")
public class WebSiteAdminController {
    @Autowired
    private WebSiteService webSiteService;

    /**
     * 根据条件查询所有
     *
     * @date 2018/4/7 17:13
     * @author porkchop
     */
    @RequestMapping("/findByPaginationWithConditions")
    public EasyUIDatagrid<WebSite> findByPaginationWithConditions(WebSite webSite, Integer page, Integer rows) {
        return webSiteService.findByPagination(webSite, page, rows);
    }

    /**
     * 更新或添加
     *
     * @date 2018/4/7 18:53
     * @author porkchop
     */
    @RequestMapping("/save")
    public ResponseResult save(WebSite webSite) {
        webSiteService.save(webSite);
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
        try {
            webSiteService.delete(ids);
            return ResponseResult.success();
        } catch (Exception e) {
            return ResponseResult.build(e.getMessage(), 500);
        }
    }

    /**
     * 查询所有
     *
     * @date 2018/4/10 10:15
     * @author porkchop
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<WebSite> findAll(String q) {
        return webSiteService.findAll(q);
    }
}
