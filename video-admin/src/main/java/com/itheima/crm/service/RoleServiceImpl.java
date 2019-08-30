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
import com.itheima.crm.mapper.RoleDao;
import com.itheima.crm.mapper.UserDao;
import com.itheima.crm.pojo.Permissions;
import com.itheima.crm.pojo.Role;
import com.itheima.crm.pojo.User;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	

/*	@Override
	public User queryByNameAndPwd(String name, String pwd) {
		
		User user =null;
		user = roleDao.queryByNameAndPwd(name, pwd);
		 return user;
	}*/

	@Override
	public void save(Role role) {
		role.setId(UUID.randomUUID().toString());
		roleDao.save(role);
	}


	@Override
	public List<Role> findAll(Integer page,Integer size) {
		PageHelper.startPage(page,size);
		return roleDao.findAll();
	}
	

	@Override
	public Role findById(String roleId) {
		
		return roleDao.findRoleById(roleId);
	}
	
	@Override
	public List<Permissions> findOtherPermissions(String roleId) {	
		return 	roleDao.findOtherPermissions(roleId);
	}
	
	@Override
	public void addPermissionToRole(String roleId, String[] permissionIds) {
		
		for (String permissionId : permissionIds) {
			roleDao.addPermissionToRole(roleId,permissionId);
		}
		
	}

}
