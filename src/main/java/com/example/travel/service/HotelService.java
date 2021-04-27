package com.example.travel.service;

import com.example.travel.bean.HotelBean;
import com.example.travel.bean.SiteBean;
import com.example.travel.mapper.HotelMapper;
import com.example.travel.mapper.SiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    HotelMapper hotelMapper;

    public List<HotelBean> getHotelList() {
        return hotelMapper.getHotelList();
    }

    public int addHotel(HotelBean hotel) {
        return hotelMapper.addHotel(hotel);
    }

    public int deleteHotel(int hotelID) { return hotelMapper.deleteHotel(hotelID); }

    public int updateHotel(HotelBean hotel) { return hotelMapper.updateHotel(hotel); }

}
