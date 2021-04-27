package com.example.travel.controller;

import com.example.travel.bean.AdminBean;
import com.example.travel.bean.UserBean;
import com.example.travel.service.AdminService;
import com.example.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public ModelAndView loginCheck(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        String userName = params.get("userName").toString();
        String userPassword = params.get("userPassword").toString();

        if (adminService.checkAdmin(userName, userPassword)) {
            modelAndView.addObject("status", "admin");
        }
        else if (userService.checkUser(userName, userPassword)) {
            modelAndView.addObject("status", "user");
        }
        else {
            modelAndView.addObject("status", "invalid");
        }
        return modelAndView;
    }
}
