package com.itheima.crm.service;

import com.itheima.crm.pojo.User;
import com.itheima.crm.pojo.Video;

public interface UserService {

	
	public User queryByNameAndPwd(String name,String pwd);
	
	public void registByNameAndPwd(User user);

	public boolean checkUsername(String word);
	
}
