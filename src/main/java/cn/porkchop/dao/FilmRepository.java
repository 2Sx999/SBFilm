package cn.porkchop.dao;


import cn.porkchop.pojo.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer>, JpaSpecificationExecutor<Film> {
    /**
     * 查询上一个电影
     *
     * @date 2018/4/16 17:25
     * @author porkchop
     */
    @Query(value = "SELECT * FROM t_film WHERE publish_date < (SELECT publish_date FROM t_film WHERE id = ?1) ORDER BY publish_date DESC LIMIT 0, 1", nativeQuery = true)
    Film getPrevious(Integer id);

    /**
     * 查询下一部电影
     *
     * @date 2018/4/16 17:25
     * @author porkchop
     */
    @Query(value = "SELECT * FROM t_film WHERE publish_date > (SELECT publish_date FROM t_film WHERE id = ?1) ORDER BY publish_date ASC LIMIT 0, 1", nativeQuery = true)
    Film getNext(Integer id);

    /**
     * 随机获取电影
     *
     * @date 2018/4/16 17:41
     * @author porkchop
     */
    @Query(value = "SELECT * FROM t_film ORDER BY rand() LIMIT ?1", nativeQuery = true)
    List<Film> getRandomList(int i);
}
