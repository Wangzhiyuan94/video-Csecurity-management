package com.itheima.crm.pojo;

import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Clob;

/*
 * 	评论表 --video-user-结合 相当于一个video的details
 * 
 */

public class Comments {

	//评论详细ID
	private Integer id;
	//视频信息
	private Integer cmmt_vid;
	//评论总数
	private Integer cmmt_count;
	//每个用户评论内容
	private Clob cmmt_content;
/*	//每个评论时间
	private Date cmmt_time;*/
	//评论作者
	private List<User> cmmt_uid;
}
