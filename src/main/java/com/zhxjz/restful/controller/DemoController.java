package com.zhxjz.restful.controller;

import com.zhxjz.restful.entity.Demo;
import com.zhxjz.restful.service.DemoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author zhangke
 * @date 16/08/2019
 */
@RestController
@RequestMapping("/demos")
public class DemoController {

    @Resource
    private DemoService demoService;

    /**
     * 新增一条demo记录
     * @param demo 新增的demo
     * @return int
     */
    @PostMapping
    public int add(@RequestBody Demo demo){
        return demoService.save(demo);
    }

    /** http://127.0.0.1:19011/zhxjz/demos
     * 获取demo列表
     * @return List<Demo>
     */
    @GetMapping
    public List<Demo> queryList(){
        return demoService.getList();
    }

    /**
     * 根据id获取一条demo记录
     * @param id demo id
     * @return Demo
     */
    @GetMapping("/{id}")
    public Demo queryOne(@PathVariable("id")Integer id){
        return demoService.getOne(id);
    }

    /**
     * 修改demo记录
     * @param id
     * @param demo
     * @return
     */
    @PutMapping("/{id}")
    public int update(@PathVariable("id")Integer id, @RequestBody Demo demo){
        demo.setId(id);
        demo.setUpdateTime(new Date());
        return demoService.update(demo);
    }

    /**
     * 删除一条demo记录
     * @param id demo id
     * @return
     */
    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id")Integer id){
        return demoService.delete(id);
    }
}
