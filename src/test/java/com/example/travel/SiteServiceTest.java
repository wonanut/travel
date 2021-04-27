package com.example.travel;

import com.example.travel.bean.AnnouncementBean;
import com.example.travel.bean.SiteBean;
import com.example.travel.mapper.AnnouncementMapper;
import com.example.travel.mapper.SiteMapper;
import com.example.travel.service.AnnouncementService;
import com.example.travel.service.SiteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SiteServiceTest {

    @Autowired
    SiteService siteService;

    @Autowired
    SiteMapper siteMapper;

    @Test
    public void AddSiteTest() {
        SiteBean siteBean = new SiteBean();
        siteBean.setSiteTitle("test");
        siteBean.setSiteStar("test");
        siteBean.setSiteDesc("test");
        siteMapper.addSite(siteBean);
    }

}
