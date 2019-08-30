package com.itheima.crm.service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.filter.AutoLoad;
import com.github.pagehelper.PageHelper;
import com.itheima.crm.mapper.UserDao;
import com.itheima.crm.pojo.Role;
import com.itheima.crm.pojo.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User queryByNameAndPwd(String name, String pwd) {
		
		User user =null;
		user = userdao.queryByNameAndPwd(name, pwd);
		 return user;
	}

	@Override
	public void save(User user) {
		user.setId(UUID.randomUUID().toString());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userdao.save(user);
	}

	@Override
	public boolean checkUsername(String word) {
		
		if(userdao.checkUsername(word) == true){
			return true;
		}
		return false;
	}

	@Override
	public List<User> findAll(Integer page,Integer size) {
		PageHelper.startPage(page,size);
		return userdao.findAll();
	}

	@Override
	public User findById(String id) {
		
		return userdao.findById(id);
	}

	@Override
	public List<Role> findOtherRoles(String userid) {	
		return 	userdao.findOtherRoles(userid);
	}

	@Override
	public void addRoleToUser(String userId, String[] roleIds) {
		
		for (String roleId : roleIds) {
			userdao.addRoleToUser(userId,roleId);
		}
		
	}
	//通过id删除用户
	@Override
	public void deleteById(String userid) {
		userdao.deleteById(userid);
		
	}

}
