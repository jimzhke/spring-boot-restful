package com.zhxjz.restful.service.impl;

import com.zhxjz.restful.entity.Demo;
import com.zhxjz.restful.mapper.DemoMapper;
import com.zhxjz.restful.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangke
 * @date 16/08/2019
 */

@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private DemoMapper demoMapper;

    @Override
    public List<Demo> getList() {
        return demoMapper.selectList();
    }

    @Override
    public Demo getOne(Integer id) {
        return demoMapper.selectOne(id);
    }

    @Override
    public int save(Demo demo) {
        return demoMapper.insert(demo);
    }

    @Override
    public int update(Demo demo) {
        return demoMapper.update(demo);
    }

    @Override
    public int delete(Integer id) {
        return demoMapper.delete(id);
    }
}
