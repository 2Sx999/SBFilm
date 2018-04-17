package cn.porkchop.dao;

import cn.porkchop.pojo.WebSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WebSiteRepository extends JpaRepository<WebSite,Integer>,JpaSpecificationExecutor<WebSite>{


}
