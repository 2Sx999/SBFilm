package cn.porkchop.controller;

import cn.porkchop.pojo.WebSiteInfo;
import cn.porkchop.service.WebSiteInfoService;
import cn.porkchop.utils.EasyUIDatagrid;
import cn.porkchop.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webSiteInfo")
public class WebSiteInfoController {

    @Autowired
    private WebSiteInfoService webSiteInfoService;

    /**
     * 分页查询 电影网站动态信息
     */
    @RequestMapping("/list/{page}")
    public String list(Model model, @PathVariable Integer page) throws Exception {
        EasyUIDatagrid<WebSiteInfo> result = webSiteInfoService.findByPagination(null, page, 20);
        model.addAttribute("webSiteInfoList", result.getRows());
        model.addAttribute("pageCode", PageUtil.genPagination("/webSiteInfo/list", result.getTotal(), page, 20));
        model.addAttribute("title", "电影网站动态信息列表");
        model.addAttribute("mainPage", "webSiteInfo/list");
        model.addAttribute("mainPageKey", "#f");
        return "basicTemplate";
    }

}
