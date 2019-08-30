package com.itheima.crm.controller;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.crm.pojo.SysLog;
import com.itheima.crm.pojo.User;
import com.itheima.crm.service.SysLogService;

@Component
@Aspect
public class LogAop {

	@Autowired
	private SysLogService sysLogService;
	
	@Autowired
	private HttpServletRequest request;
	
	private Date visitTime;//开始时间
	private Class clazz;//访问的类
	private Method method;//访问的方法
	
	//前置通知 主要获取开始时间，执行的类是哪一个，执行的哪一个方法
	@Before("execution(* com.itheima.crm.controller.*.*(..))")
	public void doBefore(JoinPoint jp) throws NoSuchMethodException, SecurityException{
		visitTime = new Date(); // 和当前时间就是开始访问的时间
		clazz = jp.getTarget().getClass();  //具体访问的类
		
		/*
		 *1.现获取访问方法名称（签名
		 *2. 通过getMethod获取访问真正的方法
		 */
		String methodName = jp.getSignature().getName();//获取将要访问方法名称
		/*clazz.getDeclaredMethod(name, parameterTypes);*/
		Object[] args = jp.getArgs();
		
		//获取具体执行的方法的method对象
		if(args==null||args.length==0){
			method = clazz.getMethod(methodName);
		}else{
			Class[] classArgs = new Class[args.length];
			for(int i=0; i<args.length;i++){
				classArgs[i] = args[i].getClass();
			}
			method = clazz.getMethod(methodName, classArgs);
		}
		
	}
	
	@After("execution(* com.itheima.crm.controller.*.*(..))")
	public void doAfter(JoinPoint jp){
		long time = new Date().getTime()-visitTime.getTime();
		
		String url = "";
		String[] classValue=null;
		String[] methodValue = null;
		//获取URL
		if(clazz!=null&&method!=null&&clazz!=SysLog.class){
			
			//1.获取类上的@RequestMapping("/order")
			RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
			if(classAnnotation!=null){
				classValue = classAnnotation.value();
				
				url += classValue[0];
				
			}
			//2.获取方法上的@RequsetMapping
			RequestMapping methodannotation = method.getAnnotation(RequestMapping.class);
			if(methodannotation!=null){
				methodValue = methodannotation.value();
				url += methodValue[0];
				
			}
			
		}
		
		//获取访问的IP地址 通过request对象
		String ip = request.getRemoteAddr();
		
		//获取当前操作的用户
		SecurityContext context = SecurityContextHolder.getContext();
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) context.getAuthentication().getPrincipal();
		String username = user.getUsername();
		
		
		//将对象塞到Syslog中
		SysLog sysLog = new SysLog();
		sysLog.setExecutionTime(time);
		sysLog.setIp(ip);
		sysLog.setMethod("[类名]" + clazz.getName() + "[方法名:]" + method.getName());
		sysLog.setUrl(url);
		sysLog.setUsername(username);
		sysLog.setVisitTime(visitTime);
		sysLog.setId(UUID.randomUUID().toString());
		sysLogService.save(sysLog);
	}
}
