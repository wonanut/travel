package com.example.travel.controller;

import com.example.travel.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadPictureController {

    // 处理上传图片
    @RequestMapping(value="/uploadPicture")
    public ModelAndView uploadPicture(@RequestParam(value = "file") MultipartFile file,
                                          HttpServletRequest request) throws IllegalStateException, IOException {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        String resourcePath = "upload/pictures";
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
