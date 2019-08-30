package com.itheima.crm.pojo;

import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Clob;

public class QueryVo {

	
	//评论详细ID
	private Integer id;
	//视频信息
	private Video video;
	//评论总数++select count(*)
	private Integer cmmt_count;
	//每个用户评论内容
	private Clob cmmt_content;
	//评论作者
	private List<User> cmmt_uid;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public Integer getCmmt_count() {
		return cmmt_count;
	}
	public void setCmmt_count(Integer cmmt_count) {
		this.cmmt_count = cmmt_count;
	}
	public Clob getCmmt_content() {
		return cmmt_content;
	}
	public void setCmmt_content(Clob cmmt_content) {
		this.cmmt_content = cmmt_content;
	}
	public List<User> getCmmt_uid() {
		return cmmt_uid;
	}
	public void setCmmt_uid(List<User> cmmt_uid) {
		this.cmmt_uid = cmmt_uid;
	}
	
	@Override
	public String toString() {
		return "QueryVo [id=" + id + ", video=" + video + ", cmmt_count=" + cmmt_count + ", cmmt_content="
				+ cmmt_content + ", cmmt_uid=" + cmmt_uid + "]";
	}
	
	
}
