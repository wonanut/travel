package com.example.travel.mapper;

import com.example.travel.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserBean> getUserList();
    List<UserBean> checkUser(String userName, String userPassword);
    UserBean getUser(String userName);
    int addUser(UserBean user);
    int deleteUser(int userID);
    int updateUser(UserBean user);
}
