package cn.porkchop.service;

import cn.porkchop.pojo.Film;
import cn.porkchop.utils.EasyUIDatagrid;

import java.util.List;

public interface FilmService {
    /**
     * 添加或修改
     *
     * @date 2018/4/7 15:58
     * @author porkchop
     */
    void save(Film film);

    /**
     * 根据条件分页查询
     *
     * @date 2018/4/7 21:58
     * @author porkchop
     */
    EasyUIDatagrid<Film> findByPagination(Film webSite, Integer page, Integer rows);

    /**
     * 删除
     *
     * @date 2018/4/8 19:43
     * @author porkchop
     */
    void delete(String ids);

    /**
     * 根据id查找
     *
     * @param id
     * @date 2018/4/8 22:35
     * @author porkchop
     */
    Film findById(Integer id);

    /**
     * 查询所有
     *
     * @param q
     * @date 2018/4/10 10:15
     * @author porkchop
     */
    List<Film> findAll(String q);

    /**
     * 获取上一个电影
     *
     * @date 2018/4/16 13:02
     * @author porkchop
     */
    Film getPrevious(Integer id);

    /**
     * 获取下一个电影
     *
     * @date 2018/4/16 13:02
     * @author porkchop
     */
    Film getNext(Integer id);

    /**
     * 随机获取电影
     *
     * @date 2018/4/16 17:40
     * @author porkchop
     */
    List<Film> getRandomList(int i);
}
