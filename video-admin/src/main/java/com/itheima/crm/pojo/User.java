package com.itheima.crm.pojo;

import java.util.Date;
import java.util.List;

public class User {

	private String id;
	private String name;
	private String password;
	//性别
	private Integer user_sex;
	//邮箱
	private String user_email;
	//生日
	private Date user_birthday;
	//手机号
	private String user_tel;
	//用户状态
	private String statusStr;
	//用户状态
	private int status;
	//用户角色
	private List<Role> roles;
	//用户权限
	private List<Permissions> permissions;
		
	
	public User() {
		super();
	}

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	

	public Integer getUser_sex() {
		return user_sex;
	}


	public void setUser_sex(Integer user_sex) {
		this.user_sex = user_sex;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public Date getUser_birthday() {
		return user_birthday;
	}


	public void setUser_birthday(Date user_birthday) {
		this.user_birthday = user_birthday;
	}


	public String getUser_tel() {
		return user_tel;
	}


	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}


	public String getStatusStr() {
		//0未开启1开启
		if(status==0){
			statusStr="未开启";
		}else if(status==1){
			statusStr="开启";
		}
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	
	public List<Permissions> getPermissions() {
		return permissions;
	}


	public void setPermissions(List<Permissions> permissions) {
		this.permissions = permissions;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", user_sex=" + user_sex
				+ ", user_email=" + user_email + ", user_birthday=" + user_birthday + ", user_tel=" + user_tel
				+ ", statusStr=" + statusStr + ", status=" + status + ", roles=" + roles + "]";
	}







	

}
