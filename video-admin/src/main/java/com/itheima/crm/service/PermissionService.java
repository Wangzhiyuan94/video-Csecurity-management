package com.itheima.crm.service;

import java.util.List;

import com.itheima.crm.pojo.Permissions;
import com.itheima.crm.pojo.User;
import com.itheima.crm.pojo.Video;

public interface PermissionService {

	

	public void save(Permissions permission);


	public List<Permissions> findAll(Integer page,Integer size);
	
	//public permission findById (String id);
	
}
