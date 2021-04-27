package com.example.travel.controller;

import com.example.travel.bean.AnnouncementBean;
import com.example.travel.bean.SiteBean;
import com.example.travel.service.AnnouncementService;
import com.example.travel.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SiteController {

    @Autowired
    SiteService siteService;

    @RequestMapping("/getSiteList")
    public ModelAndView getSiteList() {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        List<SiteBean> dataList = siteService.getSiteList();
        modelAndView.addObject("dataList", dataList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }

    @RequestMapping(value="/deleteSite", method=RequestMethod.POST)
    public ModelAndView deleteSite(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        int siteID = Integer.parseInt(params.get("siteID").toString());
        int status = siteService.deleteSite(siteID);
        List<SiteBean> dataList = siteService.getSiteList();
        modelAndView.addObject("dataList", dataList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }

    @RequestMapping(value="/addSite", method=RequestMethod.POST)
    public ModelAndView addSite(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());

        String siteTitle = params.get("siteTitle").toString();
        String siteCity = params.get("siteCity").toString();
        String siteStar = params.get("siteStar").toString();
        String sitePrice = params.get("sitePrice").toString();
        String siteDesc = params.get("siteDesc").toString();
        String sitePicture = params.get("sitePicture").toString();
        String siteAuthor = params.get("siteAuthor").toString();

        sitePicture = sitePicture.isEmpty() ? "http://img.mp.itc.cn/upload/20170703/9f5f4a5cdd3845409d704b76dfed0663_th.jpg" : sitePicture;

        SiteBean siteBean = new SiteBean();

        siteBean.setSiteTitle(siteTitle);
        siteBean.setSiteCity(siteCity);
        siteBean.setSiteStar(siteStar);
        siteBean.setSitePrice(sitePrice);
        siteBean.setSiteDesc(siteDesc);
        siteBean.setSitePicture(sitePicture);
        siteBean.setSiteAuthor(siteAuthor);

        int status = siteService.addSite(siteBean);
        List<SiteBean> dataList = siteService.getSiteList();
        modelAndView.addObject("dataList", dataList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }

    @RequestMapping(value="/updateSite", method=RequestMethod.POST)
    public ModelAndView updateSite(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());

        int siteID = Integer.parseInt(params.get("siteID").toString());
        String siteTitle = params.get("siteTitle").toString();
        String siteCity = params.get("siteCity").toString();
        String siteStar = params.get("siteStar").toString();
        String sitePrice = params.get("sitePrice").toString();
        String siteDesc = params.get("siteDesc").toString();
        String sitePicture = params.get("sitePicture").toString();
        String siteAuthor = params.get("siteAuthor").toString();

        sitePicture = sitePicture.isEmpty() ? "http://img.mp.itc.cn/upload/20170703/9f5f4a5cdd3845409d704b76dfed0663_th.jpg" : sitePicture;

        SiteBean siteBean = new SiteBean();

        siteBean.setSiteID(siteID);
        siteBean.setSiteTitle(siteTitle);
        siteBean.setSiteCity(siteCity);
        siteBean.setSiteStar(siteStar);
        siteBean.setSitePrice(sitePrice);
        siteBean.setSiteDesc(siteDesc);
        siteBean.setSitePicture(sitePicture);
        siteBean.setSiteAuthor(siteAuthor);

        int status = siteService.updateSite(siteBean);
        List<SiteBean> dataList = siteService.getSiteList();
        modelAndView.addObject("dataList", dataList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }
}
