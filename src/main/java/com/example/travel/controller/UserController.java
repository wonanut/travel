package com.example.travel.controller;

import com.example.travel.bean.UserBean;
import com.example.travel.service.UserService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.thymeleaf.context.IContext;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getUserList")
    public ModelAndView getUserList() {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        List<UserBean> userList = userService.getUserList();
        modelAndView.addObject("userList", userList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }

    @RequestMapping(value="/getUser", method=RequestMethod.POST)
    public ModelAndView getUser(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        String userName = params.get("userName").toString();
        UserBean userBean = userService.getUser(userName);
        modelAndView.addObject("userList", userBean);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }

    @RequestMapping(value="/deleteUser", method=RequestMethod.POST)
    public ModelAndView deleteUser(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        int userID = Integer.parseInt(params.get("userID").toString());
        int status = userService.deleteUser(userID);
        List<UserBean> userList = userService.getUserList();
        modelAndView.addObject("userList", userList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }

    @RequestMapping(value="/addUser", method=RequestMethod.POST)
    public ModelAndView addUser(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());

        String userName = params.get("userName").toString();
        String userPassword = params.get("userPassword").toString();
        String userDesc = params.get("userDesc").toString();
        String userPhone = params.get("userPhone").toString();
        String userSex = params.get("userSex").toString();
        String userAge = params.get("userAge").toString();

        UserBean search_userBean = userService.getUser(userName);
        if (search_userBean != null) {
            modelAndView.addObject("status", "failed");
            return modelAndView;
        }
        else {
            UserBean userBean = new UserBean();

            userDesc = userDesc.isEmpty() ? "这个人很懒，什么都没写~" : userDesc;
            userPhone = userPhone.isEmpty() ? "-" : userPhone;
            userSex = userSex.isEmpty() ? "-" : userSex;
            userAge = userAge.isEmpty() ? "-" : userAge;

            userBean.setUserName(userName);
            userBean.setUserPassword(userPassword);
            userBean.setUserDesc(userDesc);
            userBean.setUserAge(userAge);
            userBean.setUserSex(userSex);
            userBean.setUserPhone(userPhone);
            userBean.setUserProfile("http://localhost:8080/upload/userProfiles/default.jpg");

            int status = userService.addUser(userBean);
            List<UserBean> userList = userService.getUserList();
            modelAndView.addObject("userList", userList);
            modelAndView.addObject("status", "success");
            return modelAndView;
        }
    }

    @RequestMapping(value="/updateUserAdmin", method=RequestMethod.POST)
    public ModelAndView updateUserAdmin(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());

        int userID = Integer.parseInt(params.get("userID").toString());
        String userNamePrev = params.get("userNamePrev").toString();
        String userName = params.get("userName").toString();
        String userPassword = params.get("userPassword").toString();
        String userDesc = params.get("userDesc").toString();
        String userPhone = params.get("userPhone").toString();
        String userSex = params.get("userSex").toString();
        String userAge = params.get("userAge").toString();
        String userStatus = params.get("userStatus").toString();
        String userProfile = params.get("userProfile").toString();

        UserBean search_userBean = userService.getUser(userName);

        if (!userNamePrev.equals(userName) && search_userBean != null) {
            modelAndView.addObject("status", "failed");
            return modelAndView;
        }
        else {
            UserBean userBean = new UserBean();

            userDesc = userDesc.isEmpty() ? "这个人很懒，什么都没写~" : userDesc;
            userPhone = userPhone.isEmpty() ? "-" : userPhone;
            userSex = userSex.isEmpty() ? "-" : userSex;
            userAge = userAge.isEmpty() ? "-" : userAge;
            userStatus = userStatus.isEmpty() ? "normal" : userStatus;

            userBean.setUserID(userID);
            userBean.setUserName(userName);
            userBean.setUserPassword(userPassword);
            userBean.setUserDesc(userDesc);
            userBean.setUserAge(userAge);
            userBean.setUserSex(userSex);
            userBean.setUserPhone(userPhone);
            userBean.setUserProfile(userProfile);
            userBean.setUserStatus(userStatus);

            int status = userService.updateUser(userBean);
            List<UserBean> userList = userService.getUserList();
            modelAndView.addObject("userList", userList);
            modelAndView.addObject("status", "success");
            return modelAndView;
        }
    }

    @RequestMapping(value="/updateUser", method=RequestMethod.POST)
    public ModelAndView updateUser(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());

        int userID = Integer.parseInt(params.get("userID").toString());
        String userNamePrev = params.get("userNamePrev").toString();
        String userName = params.get("userName").toString();
        String userPassword = params.get("userPassword").toString();
        String userDesc = params.get("userDesc").toString();
        String userPhone = params.get("userPhone").toString();
        String userSex = params.get("userSex").toString();
        String userAge = params.get("userAge").toString();
        String userStatus = params.get("userStatus").toString();
        String userProfile = params.get("userProfile").toString();

        UserBean search_userBean = userService.getUser(userName);

        if (!userNamePrev.equals(userName) && search_userBean != null) {
            modelAndView.addObject("status", "failed");
            return modelAndView;
        }
        else {
            UserBean userBean = new UserBean();

            userDesc = userDesc.isEmpty() ? "这个人很懒，什么都没写~" : userDesc;
            userPhone = userPhone.isEmpty() ? "-" : userPhone;
            userSex = userSex.isEmpty() ? "-" : userSex;
            userAge = userAge.isEmpty() ? "-" : userAge;
            userStatus = userStatus.isEmpty() ? "normal" : userStatus;

            userBean.setUserID(userID);
            userBean.setUserName(userName);
            userBean.setUserPassword(userPassword);
            userBean.setUserDesc(userDesc);
            userBean.setUserAge(userAge);
            userBean.setUserSex(userSex);
            userBean.setUserPhone(userPhone);
            userBean.setUserProfile(userProfile);
            userBean.setUserStatus(userStatus);

            int status = userService.updateUser(userBean);
            UserBean userBeanRet = userService.getUser(userName);
            modelAndView.addObject("userList", userBeanRet);
            modelAndView.addObject("status", "success");
            return modelAndView;
        }
    }

    // 处理上传图片
    @RequestMapping(value="/uploadUserProfile")
    public ModelAndView uploadUserProfile(@RequestParam(value = "file") MultipartFile file,
                                          HttpServletRequest request) throws IllegalStateException, IOException {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        String resourcePath = "upload/userProfiles";
        String dirPath = new String("src/main/resources/static/" + resourcePath);

        File fileDirPath = new File(dirPath);
        if(!fileDirPath.exists()) {
            fileDirPath.mkdirs();
        }

        String fileName = UUID.randomUUID().toString();
        File savePath = new File(fileDirPath.getAbsolutePath() + File.separator + fileName + ".jpg");
        file.transferTo(savePath);

        String imgURL = "http://localhost:8080/" + resourcePath + "/" + fileName + ".jpg";

        modelAndView.addObject("imgURL", imgURL);
        modelAndView.addObject("status", "success");

        return modelAndView;
    }
}
