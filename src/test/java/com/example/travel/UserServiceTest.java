package com.example.travel;

import com.example.travel.bean.AdminBean;
import com.example.travel.bean.UserBean;
import com.example.travel.mapper.AdminMapper;
import com.example.travel.mapper.UserMapper;
import com.example.travel.service.AdminService;
import com.example.travel.service.UserService;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@MapperScan("com.example.travel.mapper")
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
        List<UserBean> list = userMapper.getUserList();
        for (UserBean userBean : list) {
            System.out.println(userBean.toString());
        }
    }

    @Test
    public void insertTest() {
        UserBean userBean = new UserBean();
        userBean.setUserName("李四");
        userBean.setUserAge("21");
        userBean.setUserSex("男");
        userBean.setUserPhone("182922346424");
        userBean.setUserProfile("null");
        userBean.setUserDesc("尊贵的测试用户2！");
        userBean.setUserPassword("lisi");
        userMapper.addUser(userBean);
    }

    @Test
    public void checkUserTest() {
        System.out.println(userService.checkUser("张三", "123456"));
        System.out.println(userService.checkUser("张三", "12356"));
    }

    @Test
    public void getUserTest() {
        System.out.println(userService.getUser("王五"));
    }


}
