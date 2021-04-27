package com.example.travel.mapper;


import com.example.travel.bean.AdminBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    List<AdminBean> getAdminList();
    List<AdminBean> checkAdmin(String adminName, String adminPassword);
}
