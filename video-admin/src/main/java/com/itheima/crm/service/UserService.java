package com.itheima.crm.service;

import java.util.List;

import com.itheima.crm.pojo.Role;
import com.itheima.crm.pojo.User;
import com.itheima.crm.pojo.Video;

public interface UserService {

	
	public User queryByNameAndPwd(String name,String pwd);
	
	public void save(User user);

	public boolean checkUsername(String word);
	
	public List<User> findAll(Integer page,Integer size);
	
	public User findById (String id);

	public List<Role> findOtherRoles(String userid);

	public void addRoleToUser(String userId, String[] roleIds);

	public void deleteById(String userid);
	
}
