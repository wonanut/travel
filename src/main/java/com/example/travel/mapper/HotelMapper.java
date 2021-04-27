package com.example.travel.mapper;

import com.example.travel.bean.HotelBean;
import com.example.travel.bean.SiteBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HotelMapper {
    List<HotelBean> getHotelList();
    int addHotel(HotelBean hotel);
    int deleteHotel(int hotelID);
    int updateHotel(HotelBean hotel);
}
