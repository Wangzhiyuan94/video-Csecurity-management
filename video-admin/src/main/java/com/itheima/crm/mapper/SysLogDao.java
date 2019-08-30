package com.itheima.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import com.itheima.crm.pojo.Role;
import com.itheima.crm.pojo.SysLog;
import com.itheima.crm.service.SysLogService;

public interface SysLogDao {

	
	
	
	@Insert("insert into syslog(id,visitTime,username,ip,url,executionTime,method) values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
	public void save(SysLog sysLog);

	@Select("select * from syslog order by visitTime desc")
	public List<SysLog> findAll();
		
	
}
