package com.itheima.crm.service;

import java.util.List;

import com.itheima.crm.pojo.Permissions;
import com.itheima.crm.pojo.Role;
import com.itheima.crm.pojo.User;
import com.itheima.crm.pojo.Video;

public interface RoleService {

	

	public void save(Role role);


	public List<Role> findAll(Integer page,Integer size);
	
	public Role findById (String RoleId);
	
	public List<Permissions> findOtherPermissions(String PermissionId);
	
	public void addPermissionToRole(String roleId, String[] permissionIds);
}
