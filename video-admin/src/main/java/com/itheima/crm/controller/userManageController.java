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

import javax.print.DocFlavor.STRING;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.pojo.Role;
import com.itheima.crm.pojo.Video;
import com.itheima.crm.service.UserService;
import com.itheima.crm.service.VideoService;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import com.itheima.crm.pojo.User;

@Controller
@RequestMapping("/user")
public class userManageController {

	@Autowired
	private  UserService userService;

	@Autowired(required=true)
	private UserDetailsService userDetailsService;
	
	@Autowired
	private HttpServletRequest request;	
	
	@RequestMapping("/userList")
	public ModelAndView getAll(@RequestParam(required = true,defaultValue = "1",value = "page")Integer page,
							  @RequestParam(required = true,defaultValue = "4",value = "size")Integer size)
	{
		
    	ModelAndView mv = new ModelAndView();
    	
    	List<User> users = userService.findAll(page, size);
    	//使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(users);
        
    	mv.addObject("pageInfo", pageInfo);
    	mv.setViewName("user-page-list");
    	
		return mv;
 
    }	
    
	//后台手动添加用户
	@RequestMapping(value="/deleteById")
	public @ResponseBody String deleteById(String id){
		System.out.println(id);
		userService.deleteById(id);
		return "ok";
	}

	
	//后台手动添加用户
	@RequestMapping(value="/save")
	public String save(User user,HttpServletRequest request){
		String status = request.getParameter("status");
		user.setStatus(Integer.parseInt(status));
		System.out.println(user);
		userService.save(user);
		return "redirect:userList";
	}
	
	//通过ID获得详情
	@RequestMapping(value="findById")
	public ModelAndView findById(String id){
		System.out.println(id);
		ModelAndView mv = new ModelAndView();
		User userInfo = userService.findById(id);
		mv.addObject("user",userInfo);
		mv.setViewName("user-show");
		return mv;
	}	
	
	@RequestMapping("findUserByIdAllRole")
	public ModelAndView findUserByIdAllRole(@RequestParam(value="id",required = true) String userid){
		ModelAndView mv = new ModelAndView();
		//1.根据Id查询用户
		User userInfo = userService.findById(userid);
		//2.根据用户id查询可以添加的角色
		List<Role> otherRoles = userService.findOtherRoles(userid);
		
		mv.addObject("user", userInfo);
		mv.addObject("roleList",otherRoles);
		mv.setViewName("addRoleToUser");
		return mv;
	}
		
	@RequestMapping("/addRoleToUser")
	public String addRoleToUser(@RequestParam(name = "userId",required = true ) String userId,@RequestParam(name="ids",required = true)String[] roleIds){
		userService.addRoleToUser(userId,roleIds);
		return "redirect:userList";
	}
	
}
