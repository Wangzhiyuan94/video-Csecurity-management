package com.itheima.crm.controller;

/*
 *客户管理
 * 
 */

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.pojo.User;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.service.UserService;
import com.sun.org.apache.bcel.internal.generic.RETURN;



@Controller
@SessionAttributes("user")
public class welcomeAndLoginController {

/*	@Autowired
	private  BaseDictService baseDictService;
	*/
	
	@Autowired
	private  UserService userService;
	
	//登录界面跳转
	@RequestMapping(value="/login_")
	public @ResponseBody String list(String username,String password,Model model){
		
		//通过四个对象查询
		User user = userService.queryByNameAndPwd(username, password);
		System.out.println(user);
		if(user != null){
			model.addAttribute("user",user);
			return "ok";
		}
		return "fail"; 
	}
	
		//注册界面界面跳转
		@RequestMapping(value="/regist")
		public String list(User user){		
			user.setId(UUID.randomUUID().toString());
			userService.registByNameAndPwd(user);
			return "redirect:/isRegist.jsp"; 
		}
		
		//注册界面校验
		@RequestMapping(value="/checkUsername")
		public @ResponseBody String list(String word){		
			
			if(userService.checkUsername(word)==true){
				return "ok"; 
			}
			return "fail";
		}
		//注销方法
		@RequestMapping("/outLogin")
		public String outLogin(HttpSession session,SessionStatus sessionStatus){
			
			sessionStatus.setComplete();
			return "redirect:/index.jsp";
		}
		
}
