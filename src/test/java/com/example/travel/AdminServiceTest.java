package com.example.travel;

import com.example.travel.bean.AdminBean;
import com.example.travel.mapper.AdminMapper;
import com.example.travel.service.AdminService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
//@MapperScan("com.example.travel.mapper")
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @Autowired
    AdminMapper adminMapper;

    @Test
    public void test() {
        List<AdminBean> list = adminMapper.getAdminList();
        for (AdminBean adminBean : list) {
            System.out.println(adminBean.toString());
        }
    }

    @Test
    public void checkAdminTest() {
        System.out.println(adminService.checkAdmin("admin", "root123"));
    }

}
