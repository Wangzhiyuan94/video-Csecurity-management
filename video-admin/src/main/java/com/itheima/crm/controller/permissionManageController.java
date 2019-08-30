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
import com.itheima.crm.pojo.Video;
import com.itheima.crm.service.PermissionService;
import com.itheima.crm.service.UserService;
import com.itheima.crm.service.VideoService;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import com.itheima.crm.pojo.User;

@Controller
@RequestMapping("/permission")
public class permissionManageController {

	@Autowired
	private  PermissionService permissionService;

	
	
	@RequestMapping("/findAll")
	public ModelAndView findAll(@RequestParam(required = true,defaultValue = "1",value = "page")Integer page,
							  @RequestParam(required = true,defaultValue = "4",value = "size")Integer size)
	{
		
    	ModelAndView mv = new ModelAndView();
    	List<Permissions> permissions = permissionService.findAll(page, size);
    	//使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(permissions);
        
        
        mv.addObject("pageInfo", pageInfo);
    	mv.setViewName("permission-page-list");
		return mv;
 
    }	
  

	
	//后台手动添加角色
	@RequestMapping(value="/save")
	public String save(Permissions permission){

		System.out.println(permission);
		permissionService.save(permission);
		return "redirect:/permission/findAll";
	}
	
/*	//通过ID获得详情
	@RequestMapping(value="findById")
	public ModelAndView findById(String id){
		System.out.println(id);
		ModelAndView mv = new ModelAndView();
		User userInfo = userService.findById(id);
		mv.addObject("user",userInfo);
		mv.setViewName("user-show");
		return mv;
	}*/	
	
}
