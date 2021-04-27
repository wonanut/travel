package com.example.travel.mapper;

import com.example.travel.bean.AnnouncementBean;
import com.example.travel.bean.SiteBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SiteMapper {
    List<SiteBean> getSiteList();
    int addSite(SiteBean site);
    int deleteSite(int siteID);
    int updateSite(SiteBean site);
}
