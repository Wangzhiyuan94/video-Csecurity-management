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
import com.itheima.crm.mapper.PermissionDao;
import com.itheima.crm.mapper.UserDao;
import com.itheima.crm.pojo.Permissions;
import com.itheima.crm.pojo.User;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionDao permissionDao;
	

/*	@Override
	public User queryByNameAndPwd(String name, String pwd) {
		
		User user =null;
		user = permissionDao.queryByNameAndPwd(name, pwd);
		 return user;
	}*/

	@Override
	public void save(Permissions permission) {
		permission.setId(UUID.randomUUID().toString());
		permissionDao.save(permission);
	}


	@Override
	public List<Permissions> findAll(Integer page,Integer size) {
		PageHelper.startPage(page,size);
		return permissionDao.findAll();
	}
	

/*	@Override
	public User findById(String id) {
		
		return userdao.findById(id);
	}*/

}
