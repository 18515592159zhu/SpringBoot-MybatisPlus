package com.baizhi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data //lombok的注解用来生成get set 等相关方法
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
//@TableName(value = "t_user") //默认将类名作为表名
public class User {

    @TableId(value = "id",type= IdType.AUTO)
    private String id;

    //@TableField(value = "username")
    private String name;
    private Integer age;
    private Date bir;

    //@TableField(exist = false)//不映射数据库表中的任何字段
    //private String aaa;
}