package cn.porkchop.dao;

import cn.porkchop.pojo.WebSite;
import cn.porkchop.pojo.WebSiteInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WebSiteInfoRepository extends JpaRepository<WebSiteInfo, Integer>, JpaSpecificationExecutor<WebSiteInfo> {


    /**
     * 根据电影id查询
     *
     * @date 2018/4/16 17:49
     * @author porkchop
     */
    @Query(value = "select w from WebSiteInfo w where w.film.id=?1")
    List<WebSiteInfo> getByFilmId(Integer id);
}
