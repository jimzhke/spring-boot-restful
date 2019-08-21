package com.zhxjz.restful.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Demo实体类
 *
 * @author zhangke
 * @date 16/08/2019
 *
 *  Sql数据库脚本
    drop table if exists t_demo;
    create table t_demo(
    id int not null auto_increment,
    demo_name varchar(16) not null default '' comment 'demo名称',
    demo_value varchar(16) not null default '' comment 'demo 值',
    demo_status tinyint unsigned not null default 1 comment 'demo状态：1=正常，2=屏蔽',
    create_time datetime not null default now() comment '创建时间',
    update_time datetime not null default now() comment '更新时间',
    primary key (id)
    )engine=innodb default charset=utf8;
 */
public class Demo implements Serializable{

    private static final long serialVersionUID = -5918367695437641484L;

    private Integer id;

    private String demoName;

    private String demoValue;

    private Integer demoStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }

    public String getDemoValue() {
        return demoValue;
    }

    public void setDemoValue(String demoValue) {
        this.demoValue = demoValue;
    }

    public Integer getDemoStatus() {
        return demoStatus;
    }

    public void setDemoStatus(Integer demoStatus) {
        this.demoStatus = demoStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
