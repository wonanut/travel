package com.example.travel.service;

import com.example.travel.bean.UserBean;
import com.example.travel.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<UserBean> getUserList() {
        return userMapper.getUserList();
    }

    public boolean checkUser(String userName, String userPassword) {
        List<UserBean> userList = userMapper.checkUser(userName, userPassword);
        return !userList.isEmpty();
    }

    public UserBean getUser(String userName) {
        UserBean userBean = userMapper.getUser(userName);
        return userBean;
    }

    public int addUser(UserBean user) {
        return userMapper.addUser(user);
    }

    public int deleteUser(int userID) { return userMapper.deleteUser(userID); }

    public int updateUser(UserBean user) { return userMapper.updateUser(user); }
}
