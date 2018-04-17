package cn.porkchop.controller.admin;

import cn.porkchop.pojo.Film;
import cn.porkchop.service.FilmService;
import cn.porkchop.utils.EasyUIDatagrid;
import cn.porkchop.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/film")
public class FilmAdminController {
    @Autowired
    private FilmService filmService;

    /**
     * 添加电影信息
     *
     * @date 2018/4/7 15:31
     * @author porkchop
     */
    @RequestMapping("/save")
    @ResponseBody
    public ResponseResult save(Film film) {
        filmService.save(film);
        return ResponseResult.success();
    }

    /**
     * 根据条件分页查询
     *
     * @date 2018/4/7 21:58
     * @author porkchop
     */
    @RequestMapping("/findByPaginationWithConditions")
    @ResponseBody
    public EasyUIDatagrid<Film> findByPaginationWithConditions(Film film, Integer page, Integer rows) {
        return filmService.findByPagination(film, page, rows);
    }

    /**
     * 删除
     *
     * @date 2018/4/7 18:56
     * @author porkchop
     */
    @ResponseBody
    @RequestMapping("/delete")
    public ResponseResult delete(String ids) {
        try {
            filmService.delete(ids);
            return ResponseResult.success();
        } catch (Exception e) {
            return ResponseResult.build(e.getMessage(), 500);
        }
    }

    /**
     * 根据id查找
     *
     * @date 2018/4/8 22:35
     * @author porkchop
     */
    @RequestMapping("/findById")
    public String findById(Integer id, Model model) {
        Film film = filmService.findById(id);
        model.addAttribute("film", film);
        return "admin/modifyFilm";
    }

    /**
     * 查询所有
     *
     * @date 2018/4/10 10:15
     * @author porkchop
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Film> findAll(String q) {
        return filmService.findAll(q);
    }
}
