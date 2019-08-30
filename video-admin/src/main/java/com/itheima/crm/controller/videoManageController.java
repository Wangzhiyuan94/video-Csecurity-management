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

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.pojo.Video;
import com.itheima.crm.service.UserService;
import com.itheima.crm.service.VideoService;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import com.itheima.crm.pojo.User;

@Controller
public class videoManageController {

	@Autowired
	private  UserService userService;
	
	
	@Autowired
	private  VideoService videoService;
	
//查询全部 未分页
   /* @RequestMapping("/videoList")
    public ModelAndView getAllVideo(){
		
    	ModelAndView mv = new ModelAndView();
    	
    	List<Video> allVideo = videoService.selectVideos();
    	mv.addObject("videoList", allVideo);
    	mv.setViewName("all-video-manage-list");
		return mv;
 
    }*/
	
	@RequestMapping("/videoList")
	@RolesAllowed("ADMIN")
	public ModelAndView getAllVideo(@RequestParam(required = true,defaultValue = "1",value = "page")Integer page,
							  @RequestParam(required = true,defaultValue = "4",value = "size")Integer size)
	{
		
    	ModelAndView mv = new ModelAndView();
    	
    	List<Video> videos = videoService.selectVideos(page,size);
    	//使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(videos);
        
    	mv.addObject("pageInfo", pageInfo);
    	mv.setViewName("video-page-list");
		return mv;
 
    }	
    
	//登录界面跳转
	@RequestMapping(value="/login")
	public String list(String username,String password,Model model){
		
		//通过四个对象查询
		User user = userService.queryByNameAndPwd(username, password);
		System.out.println(user);
		if(user != null){
			model.addAttribute("user",user);
			
			return "main";
		}
		//登录不成功设置跳转---未完成
		return "fail"; 
	}

	//登录界面跳转
	@RequestMapping(value="/findById")
	public ModelAndView findById(@RequestParam(required = true,value = "id")Integer video_id){
		
		System.out.println("id:"+video_id);
		ModelAndView mv = new ModelAndView();
		List<Video> videos = videoService.videoDetails(video_id);
		
		System.out.println(videos);
		
		mv.addObject("videos",videos);
		mv.setViewName("show-video-details");
		
		return mv; 
	}
	
	
	//后台手动添加视频
	@RequestMapping(value="/save")
	public String save(Video video){
		System.out.println(video);
		videoService.save(video);
		return "redirect:videoList";
	}
	
	
	
	
}
