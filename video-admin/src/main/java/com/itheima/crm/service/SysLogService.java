package com.itheima.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.pojo.Role;
import com.itheima.crm.pojo.SysLog;


public interface SysLogService {

	public void save(SysLog sysLog);
	
	public List<SysLog> findAll(Integer page,Integer size);
	
	public List<SysLog> main();
}
