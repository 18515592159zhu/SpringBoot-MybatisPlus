package com.baizhi;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class TestUserDAO {

    @Autowired
    private UserDAO userDAO;

    //查询所有
    @Test
    public void findAll() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        List<User> users = this.userDAO.selectList(wrapper);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void testFindAll() {
        List<User> users = userDAO.selectList(null);
        users.forEach(user -> System.out.println("user = " + user));
    }

    @Test
    public void testFindOne() {
        User user = userDAO.selectById("1");
        System.out.println("user = " + user);
    }

    //条件查询
    @Test
    public void testFind() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //queryWrapper.eq("age",23);//设置等值查询
        //queryWrapper.lt("age",23);//设置小于查询
        //queryWrapper.ge("age",23);//小于等于查询 gt 大于  ge 大于等于
        List<User> users = userDAO.selectList(queryWrapper);
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void testFindAllLike() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "小");
        List<User> users = userDAO.selectList(queryWrapper);
        users.forEach(user -> System.out.println("user = " + user));
    }

    @Test
    public void testSave() {
        User entity = new User();
        entity.setAge(23).setName("小明明").setBir(new Date());
        userDAO.insert(entity);
    }

    //基于id修改
    @Test
    public void testUpdateById() {
        User user = userDAO.selectById("1");
        user.setAge(24);
        userDAO.updateById(user);
    }

    //基于条件修改
    @Test
    public void testUpdate() {
        User user = userDAO.selectById("1");
        user.setName("小陈陈");
        QueryWrapper<User> updateWrapper = new QueryWrapper<>();
        updateWrapper.eq(true, "age", 23);
        userDAO.update(user, updateWrapper);
    }

    //基于id删除
    @Test
    public void testDeleteById() {
        userDAO.deleteById("3");
    }

    //基于条件删除
    @Test
    public void testDelete() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(true, User::getAge, 23);
        userDAO.delete(wrapper);
    }

    //非条件分页查询
    @Test
    public void testPage() {
        IPage<User> page = new Page<>(1, 2);
        page = userDAO.selectPage(page, null);
        page.getRecords().forEach(user -> System.out.println("user = " + user));
    }

    //带条件分页查询
    @Test
    public void testPage_1() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age", 23);
        IPage<User> page = new Page<>(1, 2);
        page = userDAO.selectPage(page, queryWrapper);
        page.getRecords().forEach(user -> System.out.println("user = " + user));
    }
}
