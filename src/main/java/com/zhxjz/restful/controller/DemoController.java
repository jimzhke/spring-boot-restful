package com.zhxjz.restful.controller;

import com.zhxjz.restful.entity.Demo;
import com.zhxjz.restful.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author zhangke
 * @date 16/08/2019
 */
@RestController
@RequestMapping("/demos")
public class DemoController {

    @Resource
    private DemoService demoService;

    private static final Logger Log = Logger.getLogger(DemoController.class.getName());

    /**
     * 获取http对象实体
     * @return 实体对象
     */
    public HttpEntity getEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return new HttpEntity<String>(headers);
    }

    /**
     * 新增一条demo记录
     * @param demo 新增的demo
     * @return int
     *
     * POST http://127.0.0.1:19012/zhxjz/demos/
     *
     * {
     *     "id": 2,
     *     "demoName": "test1",
     *     "demoValue": "1",
     *     "demoStatus": 1,
     *     "createTime": "2019-08-20 08:53:17",
     *     "updateTime": "2019-08-20 08:53:21"
     * }
     */
    @PostMapping
    public int add(@RequestBody Demo demo){
        return demoService.save(demo);
    }

    /** GET http://127.0.0.1:19012/zhxjz/demos/list
     * 获取demo列表
     * @return List<Demo>
     */
    @GetMapping("/list")
    public List<Demo> queryList(){
        return demoService.getList();
    }

    /** GET http://127.0.0.1:19012/zhxjz/demos/1
     * 根据id获取一条demo记录
     * @param id demo id
     * @return Demo
     */
    @GetMapping("/{id}")
    public Demo queryOne(@PathVariable("id")Integer id){
        return demoService.getOne(id);
    }

    /** PUT http://127.0.0.1:19012/zhxjz/demos/1
     * 修改demo记录
     * @param id
     * @param demo
     * @return
     *
     * {
     *     "id": 3,
     *     "demoName": "test1",
     *     "demoValue": "1",
     *     "demoStatus": 1,
     *     "createTime": "2019-08-20 08:53:17",
     *     "updateTime": "2019-08-20 08:53:21"
     * }
     */
    @PutMapping("/{id}")
    public int update(@PathVariable("id")Integer id, @RequestBody Demo demo){
        demo.setId(id);
        demo.setUpdateTime(new Date());
        return demoService.update(demo);
    }

    /** DELETE http://127.0.0.1:19012/zhxjz/demos/2
     * 删除一条demo记录
     * @param id demo id
     * @return
     */
    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id")Integer id){
        return demoService.delete(id);
    }

    @Autowired
    RestTemplate restTemplate;

    /**
     * 测试获取一条数据
     * @return          AlarmClass
     * @desc  http://127.0.0.1:19012/zhxjz/demos/delete/1
     *
     *  AlarmClass{id=1, name='遥测越限', description='遥测越限、跳变'}
     */
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.POST)
    public String getOneRecordData(@PathVariable("id") Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Demo demo = new Demo();
        demo.setId(id);
        HttpEntity entity = new HttpEntity(demo,headers);
        restTemplate.exchange("http://127.0.0.1:19012/zhxjz/demos/{1}", HttpMethod.POST, entity, String.class, 1).getBody();
        return "redirect:/";
    }

}
