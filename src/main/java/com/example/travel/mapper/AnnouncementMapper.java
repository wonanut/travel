package com.example.travel.mapper;

import com.example.travel.bean.AnnouncementBean;
import com.example.travel.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnouncementMapper {
    List<AnnouncementBean> getAnnouncementList();
    int addAnnouncement(AnnouncementBean announcement);
    int deleteAnnouncement(int mesgID);
    int updateAnnouncement(AnnouncementBean announcement);
}
