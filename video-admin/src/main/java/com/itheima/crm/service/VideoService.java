package com.itheima.crm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itheima.crm.pojo.Video;


public interface VideoService {

	
	public List<Video> getAllVideo();
	public List<Video> selectVideos(Integer page,Integer size);
	public List<Video> videoDetails(Integer video_id);
	
	public void uploadvideo(Video video);

	public void updateGoodCount(String id,String count);

	public void save(Video video);
}
