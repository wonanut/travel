package com.example.travel.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class ResourceConfig implements WebMvcConfigurer  {

    // 对静态资源进行重映射，从而确保实时访问到最新的图片资源
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String userProfilesPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\userProfiles\\";
        String picturePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\pictures\\";

        // 用户头像图片映射
        registry.addResourceHandler("/upload/userProfiles/**").addResourceLocations("file:"+userProfilesPath);

        // 全站其他图片映射
        registry.addResourceHandler("/upload/pictures/**").addResourceLocations("file:" + picturePath);
    }
}
