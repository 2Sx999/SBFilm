package cn.porkchop.service.impl;

import cn.porkchop.dao.LinkRepositroy;
import cn.porkchop.pojo.Link;
import cn.porkchop.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkRepositroy linkRepositroy;

    @Override
    @Transactional(readOnly = true)
    public List<Link> findAll() {
        return linkRepositroy.findAll();
    }
}
