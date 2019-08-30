package com.itheima.crm.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.filter.AutoLoad;


import com.itheima.crm.mapper.UserDao;
import com.itheima.crm.pojo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	
	@Override
	public User queryByNameAndPwd(String name, String pwd) {
		
		User user =null;
		user = userdao.queryByNameAndPwd(name, pwd);
		 return user;
	}

	@Override
	public void registByNameAndPwd(User user) {
		userdao.registByNameAndPwd(user);		
	}

	@Override
	public boolean checkUsername(String word) {
		
		if(userdao.checkUsername(word) == true){
			return true;
		}
		return false;
	}

}
