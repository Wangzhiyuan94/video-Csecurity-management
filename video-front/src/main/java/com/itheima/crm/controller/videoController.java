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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbue.utils.VideoFrame;
import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.pojo.Video;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.service.UserService;
import com.itheima.crm.service.VideoService;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import com.itheima.crm.pojo.User;

@Controller
public class videoController {

/*	@Autowired
	private  BaseDictService baseDictService;
	*/
	
	@Autowired
	private  VideoService videoService;
	
	//上传界面跳转
	@RequestMapping("/upLoad")
	public String showUpload(){
		
		return "upLoad";
	}
	
	
    @RequestMapping("/video")
    public String list(@RequestParam(required = false,defaultValue = "1",value = "pn")Integer pn,
                       Map<String,Object> map){
 
        //引入分页查询，使用PageHelper分页功能
        //在查询之前传入当前页，然后多少记录
        PageHelper.startPage(pn,12);
        //startPage后紧跟的这个查询就是分页查询
        List<Video> videos = videoService.getAllVideo();
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<>(videos,12);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        
        map.put("pageInfo",pageInfo);
        return "forward:home.jsp";
    }
    
    
    //上传视频
    @RequestMapping("/upLoadvideo")
	public String upLoadvideo(HttpServletRequest request){
    	// 解决上文件名中文乱码问题
    	DiskFileItemFactory factory = new DiskFileItemFactory();
    			
    	ServletFileUpload upload = new ServletFileUpload(factory);
    	// 解决上文件名中文乱码问题
    	upload.setHeaderEncoding("utf-8");
    	
    	// 文件大小的上限1G
    	upload.setSizeMax(1024 * 1024 * 1024 * 1);
   try {
    	List<FileItem> items = upload.parseRequest(request);

		// 2. ���� items:
		for (FileItem item : items) {
			// 若是一个一般的表单域
			if (item.isFormField()) {
				String name = item.getFieldName();
				String value = item.getString();									
			}else {// 若是文件域则把文件保存到指定目录下.
				
				String name = item.getName();
				
				//设置保存路径,也就是你根路径底下的一个文件夹中，获取真是的物理路径
				String path = request.getServletContext().getRealPath("/myvideo");
				System.out.println(path);
				
				InputStream in = item.getInputStream(); // 获取上传文件的输入流
				byte[] buffer = new byte[1024];
				int len = 0;
				
				// ...../video/testvideo.mp4
				String vadieopath = path +"/" + name; // 拼接目标文件保存的路径
				// String vadieopath = "d:/video" +"/" + name;
				
				OutputStream out = new FileOutputStream(vadieopath); // 创建输出流对象
				while ((len = in.read(buffer)) != -1) {
					out.write(buffer, 0, len);
				}

				out.close();
				in.close();
				
				/***************视频获取开始***************/
/*				String videofile = vadieopath;
				String frameFilePath = request.getServletContext().getRealPath("/grabimg");
				String targerFileName = System.currentTimeMillis()+"";
				String imageMat = "jpg";
				VideoFrame.fetchFrame(videofile, frameFilePath, targerFileName, imageMat);*/
				
				
				/***************视频获取结束***************/
				
				
				/***************视频保存开始***************/
				// 保存视频信息到数据库
		
				// 参数：从1970年1月1日 0：0：0：0到此时的毫秒数
				Timestamp uploadTime = new Timestamp(System.currentTimeMillis());
				User user = (User) request.getSession().getAttribute("user");
				String uId = user.getId();
				
				
				/*Video video = new Video(name, "myvideo/"+name, uploadTime, 0, uId,"grabimg/"+targerFileName+"."+imageMat);*/
				Video video = new Video(name, "myvideo/"+name, uploadTime, 0, uId);
				System.out.println(video);
				videoService.uploadvideo(video);// 保存
				
				// 回到主页
				
			}
		}

	} catch (FileUploadException e) {
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
   		return "redirect:index.jsp";
		
	}
    
    @RequestMapping("/updateGoodCount")
    public String GoodCount(String id,String count){
		
    	videoService.updateGoodCount(id,count);
    	
    	return "ok";
 
    }
		
}
