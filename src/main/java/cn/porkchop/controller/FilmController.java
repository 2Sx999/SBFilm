package cn.porkchop.controller;

import cn.porkchop.pojo.Film;
import cn.porkchop.service.FilmService;
import cn.porkchop.service.WebSiteInfoService;
import cn.porkchop.utils.EasyUIDatagrid;
import cn.porkchop.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmService filmService;
    @Autowired
    private WebSiteInfoService webSiteInfoService;

    /**
     * 搜索
     *
     * @date 2018/4/15 13:24
     * @author porkchop
     */
    @RequestMapping("/search")
    public String search(@Valid Film film, BindingResult bindingResult, Model model) {
        EasyUIDatagrid<Film> result = filmService.findByPagination(film, 1, 128);
        model.addAttribute("filmList", result.getRows());
        model.addAttribute("s_film", film);
        model.addAttribute("total", result.getTotal());
        model.addAttribute("title", "搜索" + film.getName());
        model.addAttribute("mainPage", "film/searchResult");
        model.addAttribute("mainPageKey", "#f");
        return "basicTemplate";
    }

    /**
     * 分页显示收录的电影
     *
     * @date 2018/4/15 13:25
     * @author porkchop
     */
    @RequestMapping("/list/{page}")
    public String list(@PathVariable Integer page, Model model) {
        EasyUIDatagrid<Film> result = filmService.findByPagination(null, page, 32);
        model.addAttribute("filmList", result.getRows());
        model.addAttribute("title", "电影列表");
        model.addAttribute("mainPage", "film/list");
        model.addAttribute("mainPageKey", "#f");
        model.addAttribute("pageCode", PageUtil.genPagination("/film/list", result.getTotal(), page, 32));
        return "basicTemplate";
    }

    /**
     * 显示详细信息
     *
     * @date 2018/4/16 12:59
     * @author porkchop
     */
    @RequestMapping("/{id}")
    public String showDetail(Model model, @PathVariable Integer id) {
        Film film = filmService.findById(id);
        model.addAttribute("film", film);
        model.addAttribute("title", film.getTitle() + "--影视宅");
        model.addAttribute("randomFilmList", filmService.getRandomList(8));
        model.addAttribute("webSiteInfoList", webSiteInfoService.getByFilmId(id));
        model.addAttribute("pageCode", this.getUpAndDownPageCode(filmService.getPrevious(id), filmService.getNext(id)));
        model.addAttribute("mainPage", "film/detail");
        model.addAttribute("mainPageKey", "#f");
        return "basicTemplate";
    }

    /**
     * 获取下一个电影你和上一个电影
     *
     * @param lastFilm
     * @param nextFilm
     * @return
     */
    private String getUpAndDownPageCode(Film lastFilm, Film nextFilm) {
        StringBuffer pageCode = new StringBuffer();
        if (lastFilm == null || lastFilm.getId() == null) {
            pageCode.append("<p>上一部：没有了</p>");
        } else {
            pageCode.append("<p>上一部：<a target='_blank' href='/film/" + lastFilm.getId() + "'>" + lastFilm.getTitle() + "</a></p>");
        }
        if (nextFilm == null || nextFilm.getId() == null) {
            pageCode.append("<p>下一部：没有了</p>");
        } else {
            pageCode.append("<p>下一部：<a target='_blank' href='/film/" + nextFilm.getId() + "'>" + nextFilm.getTitle() + "</a></p>");
        }
        return pageCode.toString();
    }
}
