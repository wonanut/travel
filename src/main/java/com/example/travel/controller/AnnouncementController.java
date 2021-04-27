package com.example.travel.controller;

import com.example.travel.bean.AnnouncementBean;
import com.example.travel.bean.UserBean;
import com.example.travel.service.AnnouncementService;
import com.example.travel.service.UserService;
import com.example.travel.utils.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
public class AnnouncementController {

    @Autowired
    AnnouncementService announcementService;

    @RequestMapping("/getAnnouncementList")
    public ModelAndView getAnnouncementList() {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        List<AnnouncementBean> mesgList = announcementService.getAnnouncementList();
        modelAndView.addObject("mesgList", mesgList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }

    @RequestMapping(value="/deleteAnnouncement", method=RequestMethod.POST)
    public ModelAndView deleteAnnouncement(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        int mesgID = Integer.parseInt(params.get("mesgID").toString());
        int status = announcementService.deleteAnnouncement(mesgID);
        List<AnnouncementBean> mesgList = announcementService.getAnnouncementList();
        modelAndView.addObject("mesgList", mesgList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }

    @RequestMapping(value="/addAnnouncement", method=RequestMethod.POST)
    public ModelAndView addAnnouncement(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());

        String mesgTitle = params.get("mesgTitle").toString();
        String mesgDesc = params.get("mesgDesc").toString();
        String mesgAuthor = params.get("mesgAuthor").toString();

        DateFormatter dateFormatter = new DateFormatter();
        String mesgDate = dateFormatter.getDate();

        AnnouncementBean announcementBean = new AnnouncementBean();

        announcementBean.setMesgTitle(mesgTitle);
        announcementBean.setMesgDesc(mesgDesc);
        announcementBean.setMesgAuthor(mesgAuthor);
        announcementBean.setMesgDate(mesgDate);

        int status = announcementService.addAnnouncement(announcementBean);
        List<AnnouncementBean> mesgList = announcementService.getAnnouncementList();
        modelAndView.addObject("mesgList", mesgList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }

    @RequestMapping(value="/updateAnnouncement", method=RequestMethod.POST)
    public ModelAndView updateAnnouncement(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());

        int mesgID = Integer.parseInt(params.get("mesgID").toString());
        String mesgTitle = params.get("mesgTitle").toString();
        String mesgDesc = params.get("mesgDesc").toString();
        String mesgAuthor = params.get("mesgAuthor").toString();
//        String mesgPicture = params.get("mesgPicture").toString();

        AnnouncementBean announcementBean = new AnnouncementBean();

        announcementBean.setMesgID(mesgID);
        announcementBean.setMesgTitle(mesgTitle);
        announcementBean.setMesgDesc(mesgDesc);
        announcementBean.setMesgAuthor(mesgAuthor);
//        announcementBean.setMesgPicture(mesgPicture);

        int status = announcementService.updateAnnouncement(announcementBean);
        List<AnnouncementBean> mesgList = announcementService.getAnnouncementList();
        modelAndView.addObject("mesgList", mesgList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }
}
