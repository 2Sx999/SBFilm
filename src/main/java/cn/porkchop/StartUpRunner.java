package cn.porkchop;

import cn.porkchop.pojo.Film;
import cn.porkchop.service.FilmService;
import cn.porkchop.service.LinkService;
import cn.porkchop.service.WebSiteInfoService;
import cn.porkchop.service.WebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
public class StartUpRunner implements CommandLineRunner, ServletContextListener {

    private ServletContext context;
    @Autowired
    private WebSiteService webSiteService;
    @Autowired
    private WebSiteInfoService webSiteInfoService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private LinkService linkService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    public void loadData() {
        // 最新10条电影动态
        context.setAttribute("newestInfoList", webSiteInfoService.findByPagination(null, 1, 10).getRows());
        Film film = new Film();
        film.setHot(1);
        // 获取最新10条热门电影
        context.setAttribute("newestHotFilmList", filmService.findByPagination(film, 1, 10).getRows());
        // 获取最新32条热门电影 首页显示用到
        context.setAttribute("newestIndexHotFilmList", filmService.findByPagination(film, 1, 32).getRows());
        // 获取最新10条电影网站收录
        context.setAttribute("newestWebSiteList", webSiteService.findByPagination(null, 1, 10).getRows());
        // 获取最新10条电影信息
        context.setAttribute("newestFilmList", filmService.findByPagination(null, 1, 10).getRows());
        // 查询所有友情链接
        context.setAttribute("linkList", linkService.findAll());
    }
}
