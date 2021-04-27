package com.example.travel.service;

import com.example.travel.bean.AnnouncementBean;
import com.example.travel.bean.SiteBean;
import com.example.travel.mapper.AnnouncementMapper;
import com.example.travel.mapper.SiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {

    @Autowired
    SiteMapper siteMapper;

    public List<SiteBean> getSiteList() {
        return siteMapper.getSiteList();
    }

    public int addSite(SiteBean siteBean) {
        return siteMapper.addSite(siteBean);
    }

    public int deleteSite(int siteID) { return siteMapper.deleteSite(siteID); }

    public int updateSite(SiteBean site) { return siteMapper.updateSite(site); }

}
