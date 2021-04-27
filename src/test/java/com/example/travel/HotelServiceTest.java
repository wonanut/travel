package com.example.travel;

import com.example.travel.bean.HotelBean;
import com.example.travel.bean.SiteBean;
import com.example.travel.mapper.HotelMapper;
import com.example.travel.mapper.SiteMapper;
import com.example.travel.service.HotelService;
import com.example.travel.service.SiteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HotelServiceTest {

    @Autowired
    HotelService hotelService;

    @Autowired
    HotelMapper hotelMapper;

    @Test
    public void AddSiteTest() {
        HotelBean hotelbean = new HotelBean();
        hotelbean.setHotelName("test");
        hotelbean.setHotelDesc("test");
        hotelbean.setHotelRemain("test");
        hotelMapper.addHotel(hotelbean);
    }

}
