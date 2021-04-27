package com.example.travel.service;

import com.example.travel.bean.AnnouncementBean;
import com.example.travel.mapper.AnnouncementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {

    @Autowired
    AnnouncementMapper announcementMapper;

    public List<AnnouncementBean> getAnnouncementList() {
        return announcementMapper.getAnnouncementList();
    }

    public int addAnnouncement(AnnouncementBean announcement) {
        return announcementMapper.addAnnouncement(announcement);
    }

    public int deleteAnnouncement(int mesgID) { return announcementMapper.deleteAnnouncement(mesgID); }

    public int updateAnnouncement(AnnouncementBean announcement) { return announcementMapper.updateAnnouncement(announcement); }

}
