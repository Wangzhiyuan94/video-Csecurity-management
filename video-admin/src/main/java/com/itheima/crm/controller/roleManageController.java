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
import com.itheima.crm.pojo.Video;
import com.itheima.crm.service.RoleService;
import com.itheima.crm.service.UserService;
import com.itheima.crm.service.VideoService;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import com.itheima.crm.pojo.User;

@Controller
@RequestMapping("/role")
public class roleManageController {

	@Autowired
	private  RoleService roleService;

	
	
	@RequestMapping("/findAll")
	public ModelAndView findAll(@RequestParam(required = true,defaultValue = "1",value = "page")Integer page,
							  @RequestParam(required = true,defaultValue = "4",value = "size")Integer size)
	{
		
    	ModelAndView mv = new ModelAndView();
    	List<Role> roles = roleService.findAll(page, size);
    	//使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(roles);
        
        
        mv.addObject("pageInfo", pageInfo);
    	mv.setViewName("role-page-list");
		return mv;
 
    }	
  

	
	//后台手动添加角色
	@RequestMapping(value="/save")
	public String save(Role role){

		System.out.println(role);
		roleService.save(role);
		return "redirect:/role/findAll";
	}
	
	@RequestMapping("findRoleByIdAllPermission")
	public ModelAndView findroleByIdAllPermission(@RequestParam(value="id",required = true) String roleId){
		ModelAndView mv = new ModelAndView();
		//1.根据Id查询用户
		Role roleInfo = roleService.findById(roleId);
		//2.根据用户id查询可以添加的角色
		List<Permissions> otherPermissions = roleService.findOtherPermissions(roleId);
		
		mv.addObject("role", roleInfo);
		mv.addObject("permissionList",otherPermissions);
		mv.setViewName("addPermissionToRole");
		return mv;
	}
		
	@RequestMapping("/addPermissionToRole")
	public String addPermissionToRole(@RequestParam(name = "roleId",required = true ) String roleId,@RequestParam(name="ids",required = true)String[] PermissionIds){
		roleService.addPermissionToRole(roleId,PermissionIds);
		return "redirect:findAll";
	}
	
}
