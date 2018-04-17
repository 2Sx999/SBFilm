package cn.porkchop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageContoller {
    /**
     * 网站根目录
     *
     * @date 2018/4/7 13:46
     * @author porkchop
     */
    @RequestMapping("/")
    public String root(Model model) {
        model.addAttribute("title", "首页");
        model.addAttribute("mainPage", "film/indexHotFilms");
        model.addAttribute("mainPageKey", "#f");
        return "basicTemplate";
    }

    /**
     * 登陆
     *
     * @date 2018/4/7 13:46
     * @author porkchop
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 跳转到后台页面
     *
     * @date 2018/4/7 13:45
     * @author porkchop
     */
    @RequestMapping("/admin")
    public String toAdmin() {
        return "admin/main";
    }

    /**
     * 关于本站
     *
     * @date 2018/4/17 15:16
     * @author porkchop
     */
    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "关于本站");
        model.addAttribute("mainPage", "common/about");
        model.addAttribute("mainPageKey", "#a");
        return "basicTemplate";
    }


    /**
     * 跳转管理的页面
     *
     * @date 2018/4/8 19:49
     * @author porkchop
     */
    @RequestMapping("/admin/page/{page}")
    public String adminPage(@PathVariable String page) {
        return "admin/" + page;
    }
}
