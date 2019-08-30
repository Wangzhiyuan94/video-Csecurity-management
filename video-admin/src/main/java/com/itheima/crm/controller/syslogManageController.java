package com.itheima.crm.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;

/*
 *客户管理
 * 
 */

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.omg.CORBA.NVList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.Permissions;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.pojo.Role;
import com.itheima.crm.pojo.SysLog;
import com.itheima.crm.pojo.Video;
import com.itheima.crm.service.RoleService;
import com.itheima.crm.service.SysLogService;
import com.itheima.crm.service.UserService;
import com.itheima.crm.service.VideoService;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import com.itheima.crm.pojo.User;

@Controller
@RequestMapping("/syslog")
public class syslogManageController {

	@Autowired
	private  SysLogService sysLogService;

	
	
	@RequestMapping("/findAll")
	public ModelAndView findAll(@RequestParam(required = true,defaultValue = "1",value = "page")Integer page,
							  @RequestParam(required = true,defaultValue = "10",value = "size")Integer size)
	{
		
    	ModelAndView mv = new ModelAndView();
    	List<SysLog> sysLogs = sysLogService.findAll(page, size);
    	//使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(sysLogs);
        
        
        mv.addObject("pageInfo", pageInfo);
    	mv.setViewName("syslog-page-list");
		return mv;
 
    }	
  
	@RequestMapping("/main")
	public ModelAndView findAll()
	{
		
    	ModelAndView mv = new ModelAndView();
    	List<SysLog> sysLogs = sysLogService.main();
    	//使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        
        
        mv.addObject("sysLogs", sysLogs);
    	mv.setViewName("main");
		return mv;
 
    }		
	
}
