package com.itheima.crm.mapper;

import java.sql.SQLException;
import java.util.List;


import org.apache.ibatis.annotations.Param;

import com.itheima.crm.pojo.Video;


public interface VideoDao {

	public List<Video> getAllVideo();
	
	//以视频为中心一对一关联用户
	public List<Video> selectVideos();
	
	public List<Video> videoDetails(Integer video_id);
	
	
	public void uploadvideo(Video video);

	public void updateGoodCount(@Param("id")String id, @Param("count")String count); 
}
