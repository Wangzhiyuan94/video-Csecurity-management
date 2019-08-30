package com.itheima.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.itheima.crm.mapper.SysLogDao;
import com.itheima.crm.pojo.SysLog;


@Service
@Transactional
public class SysLogServiceImpl implements SysLogService{

	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public void save(SysLog sysLog) {
		sysLogDao.save(sysLog);
		
	}

	@Override
	public List<SysLog> findAll(Integer page, Integer size) {
		PageHelper.startPage(page,size);
		return sysLogDao.findAll();
	}

	@Override
	public List<SysLog> main() {
		return sysLogDao.findAll();
	}

}
