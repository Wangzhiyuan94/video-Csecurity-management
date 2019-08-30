package com.itheima.crm.controller;
/*
 *客户管理
 * 
 */

import java.util.List;

import javax.print.DocFlavor.URL;
import javax.servlet.Filter;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;
import com.sun.org.apache.bcel.internal.generic.RETURN;



@Controller
public class CustomerController {

	@Autowired
	private  BaseDictService baseDictService;
	
	@Autowired
	private  CustomerService customerService;
	
/*	//注解在成员变量上
	@Value("${fromType.code}")
	private String fromTypeCode;
	
	@Value("${industryType.code}")
	private String industryTypeCode;
	
	@Value("${levelType.code}")
	private String levelTypeCode;*/
	
	//程序入口
	@RequestMapping(value="/customer/list")
	public String list(QueryVo vo,Model model){
		
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode("002");
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		System.out.println("表现层："+vo);
		//通过四个对象查询
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry",vo.getCustIndustry());
		model.addAttribute("custName",vo.getCustName());
		model.addAttribute("custLevel",vo.getCustLevel());
		
		return "customer";
	}
	
	@RequestMapping(value="/customer/edit.action")
	public @ResponseBody Customer edit(Integer id){
		
		return customerService.selectCustomerById(id);
	}
	
	//修改
	@RequestMapping(value="/customer/update.action")
	public @ResponseBody String update(Customer customer){
		
		customerService.updateCustomerById(customer);
		return "ok";
	}

	//删除
		@RequestMapping(value="/customer/delete.action")
		public @ResponseBody String delete(Integer id){
			
			customerService.deleteCustomerById(id);
			return "ok";
		}
/*		@Test 
	    public void get(){ 
	        java.net.URL url = Filter.class.getProtectionDomain().getCodeSource().getLocation(); 
	        System.out.println("path:"+url.getPath()+"  name:"+url.getFile()); 
	    }*/
	
}
