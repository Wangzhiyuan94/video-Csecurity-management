package com.itheima.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.mapper.VideoDao;
import com.itheima.crm.pojo.Video;

@Service
public class VideoServiceImp implements VideoService{

	@Autowired
	private VideoDao videodao;
	
	@Override
	public List<Video> getAllVideo() {
		
		return videodao.getAllVideo();
	}
	//上传视频
	public void uploadvideo(Video video){
		System.out.println(video);
		videodao.uploadvideo(video);
	}
	@Override
	public void updateGoodCount(String id, String count) {
		System.out.println("id:"+id+"count:"+count);
		videodao.updateGoodCount(id,count);
		
	}

	
}
