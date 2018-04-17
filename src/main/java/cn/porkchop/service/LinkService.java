package cn.porkchop.service;

import cn.porkchop.pojo.Link;

import java.util.List;

public interface LinkService {
    /**
     * 查询所有
     *
     * @date 2018/4/14 15:11
     * @author porkchop
     */
    List<Link> findAll();
}
