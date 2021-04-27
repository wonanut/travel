package com.example.travel.controller;

import com.example.travel.bean.HotelBean;
import com.example.travel.bean.SiteBean;
import com.example.travel.service.HotelService;
import com.example.travel.service.SiteService;
import com.example.travel.utils.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;
import java.util.Map;

@Controller
public class HotelController {

    @Autowired
    HotelService hotelService;

    @RequestMapping("/getHotelList")
    public ModelAndView getHotelList() {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        List<HotelBean> dataList = hotelService.getHotelList();
        modelAndView.addObject("dataList", dataList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }

    @RequestMapping(value="/deleteHotel", method=RequestMethod.POST)
    public ModelAndView deleteHotel(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        int hotelID = Integer.parseInt(params.get("hotelID").toString());
        int status = hotelService.deleteHotel(hotelID);
        List<HotelBean> dataList = hotelService.getHotelList();
        modelAndView.addObject("dataList", dataList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }

    @RequestMapping(value="/addHotel", method=RequestMethod.POST)
    public ModelAndView addHotel(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());

        String hotelName = params.get("hotelName").toString();
        String hotelDesc = params.get("hotelDesc").toString();
        String hotelAddress = params.get("hotelAddress").toString();
        String hotelPrice = params.get("hotelPrice").toString();
        String hotelStar = params.get("hotelStar").toString();
        String hotelPhone = params.get("hotelPhone").toString();
        String hotelRemain = params.get("hotelRemain").toString();
        String hotelPicture = params.get("hotelPicture").toString();
        String hotelAuthor = params.get("hotelAuthor").toString();

        DateFormatter dateFormatter = new DateFormatter();
        String hotelDate = dateFormatter.getDate();

        hotelPicture = hotelPicture.isEmpty() ? "https://5b0988e595225.cdn.sohucs.com/images/20171212/14f763a8cd144b60860d560c39ebce4f.jpeg" : hotelPicture;

        HotelBean hotelBean = new HotelBean();

        hotelBean.setHotelName(hotelName);
        hotelBean.setHotelDesc(hotelDesc);
        hotelBean.setHotelAddress(hotelAddress);
        hotelBean.setHotelPrice(hotelPrice);
        hotelBean.setHotelStar(hotelStar);
        hotelBean.setHotelPhone(hotelPhone);
        hotelBean.setHotelRemain(hotelRemain);
        hotelBean.setHotelPicture(hotelPicture);
        hotelBean.setHotelAuthor(hotelAuthor);
        hotelBean.setHotelDate(hotelDate);
        hotelBean.setHotelStatus("normal");

        int status = hotelService.addHotel(hotelBean);
        List<HotelBean> dataList = hotelService.getHotelList();
        modelAndView.addObject("dataList", dataList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }

    @RequestMapping(value="/updateHotel", method=RequestMethod.POST)
    public ModelAndView updateHotel(@RequestParam Map<String, Object> params) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());

        int hotelID = Integer.parseInt(params.get("hotelID").toString());
        String hotelName = params.get("hotelName").toString();
        String hotelDesc = params.get("hotelDesc").toString();
        String hotelAddress = params.get("hotelAddress").toString();
        String hotelPrice = params.get("hotelPrice").toString();
        String hotelStar = params.get("hotelStar").toString();
        String hotelPhone = params.get("hotelPhone").toString();
        String hotelRemain = params.get("hotelRemain").toString();
        String hotelPicture = params.get("hotelPicture").toString();
        String hotelAuthor = params.get("hotelAuthor").toString();

        hotelPicture = hotelPicture.isEmpty() ? "https://5b0988e595225.cdn.sohucs.com/images/20171212/14f763a8cd144b60860d560c39ebce4f.jpeg" : hotelPicture;

        HotelBean hotelBean = new HotelBean();

        hotelBean.setHotelID(hotelID);
        hotelBean.setHotelName(hotelName);
        hotelBean.setHotelDesc(hotelDesc);
        hotelBean.setHotelAddress(hotelAddress);
        hotelBean.setHotelPrice(hotelPrice);
        hotelBean.setHotelStar(hotelStar);
        hotelBean.setHotelPhone(hotelPhone);
        hotelBean.setHotelRemain(hotelRemain);
        hotelBean.setHotelPicture(hotelPicture);
        hotelBean.setHotelAuthor(hotelAuthor);

        int status = hotelService.updateHotel(hotelBean);
        List<HotelBean> dataList = hotelService.getHotelList();
        modelAndView.addObject("dataList", dataList);
        modelAndView.addObject("status", "success");
        return modelAndView;
    }
}
