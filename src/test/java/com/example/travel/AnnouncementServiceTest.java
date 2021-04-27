package com.example.travel;

import com.example.travel.bean.AnnouncementBean;
import com.example.travel.mapper.AnnouncementMapper;
import com.example.travel.mapper.UserMapper;
import com.example.travel.service.AnnouncementService;
import com.example.travel.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AnnouncementServiceTest {

    @Autowired
    AnnouncementService announcementService;

    @Autowired
    AnnouncementMapper announcementMapper;

    @Test
    public void AddAnnouncementTest() {
        AnnouncementBean announcementBean = new AnnouncementBean();
        announcementBean.setMesgTitle("test");
        announcementBean.setMesgDesc("test");
        announcementBean.setMesgAuthor("admin");
        announcementMapper.addAnnouncement(announcementBean);
    }

}
