package cn.porkchop.controller;

import cn.porkchop.pojo.WebSite;
import cn.porkchop.service.WebSiteService;
import cn.porkchop.utils.EasyUIDatagrid;
import cn.porkchop.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/webSite")
@Controller
public class WebSiteController {
    @Autowired
    private WebSiteService webSiteService;

    /**
     * 分页显示收录网站
     *
     * @date 2018/4/17 15:09
     * @author porkchop
     */
    @RequestMapping("/list/{page}")
    public String list(Model model, @PathVariable @RequestParam(defaultValue = "1") Integer page) throws Exception {
        EasyUIDatagrid<WebSite> result = webSiteService.findByPagination(null, page, 20);
        model.addAttribute("webSiteList", result.getRows());
        model.addAttribute("pageCode", PageUtil.genPagination("/website/list", result.getTotal(), page, 20));
        model.addAttribute("title", "电影网站列表");
        model.addAttribute("mainPage", "website/list");
        model.addAttribute("mainPageKey", "#f");
        return "basicTemplate";
    }

}
