package com.itheima.crm.mapper;

import org.apache.ibatis.annotations.Param;

import com.itheima.crm.pojo.User;



public interface UserDao {

	public User queryByNameAndPwd(@Param("name")String name,@Param("pwd")String pwd);
	
	public void registByNameAndPwd(User user);
	
	public boolean checkUsername(String word);
}
