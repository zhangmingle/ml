package com.ml.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.ml.test.InnerAnnouncement;

public interface InnerAnnouncementMapper {
	
	public InnerAnnouncement selectInnerAnnouncementById(@Param("id") int id);
        
    public void insertInnerAnnouncement(InnerAnnouncement innerAnnouncement);
    
    public void updateInnerAnnouncement(InnerAnnouncement innerAnnouncement);
    
    public void deleteInnerAnnouncementLocationByInnerAnnouncementId(@Param("innerAnnouncementId") int innerAnnouncementId);
    
}
