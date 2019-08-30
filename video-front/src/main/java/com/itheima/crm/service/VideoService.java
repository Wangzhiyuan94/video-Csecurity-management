package com.itheima.crm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itheima.crm.pojo.Video;

public interface VideoService {

	
	public List<Video> getAllVideo();
	
	public void uploadvideo(Video video);

	public void updateGoodCount(String id,String count);
}
