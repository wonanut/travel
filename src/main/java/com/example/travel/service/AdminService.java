package com.example.travel.service;


import com.example.travel.bean.AdminBean;
import com.example.travel.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    public List<AdminBean> getAdminList() {
        return adminMapper.getAdminList();
    }

    public boolean checkAdmin(String adminName, String adminPassword) {
        List<AdminBean> adminList = adminMapper.checkAdmin(adminName, adminPassword);
        return !adminList.isEmpty();
    }

}
