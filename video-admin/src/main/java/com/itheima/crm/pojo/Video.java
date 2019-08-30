package com.itheima.crm.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class Video {
	
	private Integer id;
	private String description;
	private String path;
	private String videoName;
	private Date upLoadTime;
	private int goodCount;
	private int types;
	private String uid;
	private String picPath;
	private int video_Status;
	private String video_StatusStr;//0为审核中,1为正常	
	
	//附加用户对象名称
	private User user;
	
	
	
	
	public Video(Integer id, String description, String path, String videoName, Date upLoadTime, int goodCount,
			int types, String uid, String picPath) {
		super();
		this.id = id;
		this.description = description;
		this.path = path;
		this.videoName = videoName;
		this.upLoadTime = upLoadTime;
		this.goodCount = goodCount;
		this.types = types;
		this.uid = uid;
		this.picPath = picPath;
	}


	public String getPicPath() {
		return picPath;
	}


	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}




	public Video(String videoName, String path,  Date upLoadTime, int goodCount, String uid,String picPath) {
		super();
		this.path = path;
		this.videoName = videoName;
		this.upLoadTime = upLoadTime;
		this.goodCount = goodCount;
		this.uid = uid;
		this.picPath = picPath;
	}

	public Video(String videoName, String path,  Date upLoadTime, int goodCount, String uid) {
		super();
		this.path = path;
		this.videoName = videoName;
		this.upLoadTime = upLoadTime;
		this.goodCount = goodCount;
		this.uid = uid;
	}


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public String getVideoName() {
		return videoName;
	}



	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}


	public Date getUpLoadTime() {
		return upLoadTime;
	}


	public void setUpLoadTime(Date upLoadTime) {
		this.upLoadTime = upLoadTime;
	}


	public int getGoodCount() {
		return goodCount;
	}



	public void setGoodCount(int goodCount) {
		this.goodCount = goodCount;
	}



	public int getTypes() {
		return types;
	}



	public void setTypes(int types) {
		this.types = types;
	}



	public String getUid() {
		return uid;
	}



	public void setUid(String uid) {
		this.uid = uid;
	}



	public int getVideo_Status() {
		return video_Status;
	}


	public void setVideo_Status(int video_Status) {
		this.video_Status = video_Status;
	}

	

	public String getVideo_StatusStr() {
			if(video_Status == 0){
				video_StatusStr="审核中"; 
			}
			if(video_Status == 1){
				video_StatusStr="通过"; 
			}
		return video_StatusStr;
	}


	public void setVideo_StatusStr(String video_StatusStr) {
		this.video_StatusStr = video_StatusStr;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Video() {
		super();
	}


	@Override
	public String toString() {
		return "Video [id=" + id + ", description=" + description + ", path=" + path + ", videoName=" + videoName
				+ ", upLoadTime=" + upLoadTime + ", goodCount=" + goodCount + ", types=" + types + ", uid=" + uid
				+ ", picPath=" + picPath + ", video_Status=" + video_Status + ", video_StatusStr=" + video_StatusStr
				+ ", user=" + user + "]";
	}



	
}
