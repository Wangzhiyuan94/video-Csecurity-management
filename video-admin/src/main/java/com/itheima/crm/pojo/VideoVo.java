package com.itheima.crm.pojo;

import java.util.Date;

public class VideoVo {

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
}
