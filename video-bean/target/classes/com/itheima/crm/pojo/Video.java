package com.itheima.crm.pojo;

import java.sql.Timestamp;

public class Video {
	
	private Integer id;
	private String description;
	private String path;
	private String videoName;
	private Timestamp upLoadTime;
	private int goodCount;
	private int types;
	private String uid;
	private String picPath;
	
	
	
	

	public Video(String picPath , Integer id, String description, String path, String videoName, Timestamp upLoadTime, int goodCount,
			int types, String uid) {
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




	public Video(String videoName, String path,  Timestamp upLoadTime, int goodCount, String uid,String picPath) {
		super();
		this.path = path;
		this.videoName = videoName;
		this.upLoadTime = upLoadTime;
		this.goodCount = goodCount;
		this.uid = uid;
		this.picPath = picPath;
	}

	public Video(String videoName, String path,  Timestamp upLoadTime, int goodCount, String uid) {
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



	public Timestamp getUpLoadTime() {
		return upLoadTime;
	}



	public void setUpLoadTime(Timestamp upLoadTime) {
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







	@Override
	public String toString() {
		return "Video [id=" + id + ", description=" + description + ", path=" + path + ", videoName=" + videoName
				+ ", upLoadTime=" + upLoadTime + ", goodCount=" + goodCount + ", types=" + types + ", uid=" + uid
				+ ", picPath=" + picPath + "]";
	}




	public Video() {
		super();
	}



	
}
