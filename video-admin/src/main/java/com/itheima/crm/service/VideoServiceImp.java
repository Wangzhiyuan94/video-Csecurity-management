package com.itheima.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.itheima.crm.mapper.VideoDao;
import com.itheima.crm.pojo.Video;

@Service
@Transactional
public class VideoServiceImp implements VideoService{

	@Autowired
	private VideoDao videodao;
	
	@Override
	public List<Video> getAllVideo() {
		
		return videodao.getAllVideo();
	}
	
	//关联查询整个列表
	@Override
	public List<Video> selectVideos(Integer page,Integer size) {
		
		PageHelper.startPage(page,size);
		return videodao.selectVideos();
	}
	
	//关联查询整个列表
	@Override
	public List<Video> videoDetails(Integer video_id) {
		
		return videodao.videoDetails(video_id);
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
	@Override
	public void save(Video video) {
		
		videodao.uploadvideo(video);
	}

	
}
