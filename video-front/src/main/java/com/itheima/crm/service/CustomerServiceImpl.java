package com.itheima.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.common.utils.Page;
import com.itheima.crm.mapper.CustomerDao;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

/*
 * 客户管理 
 */

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	

	//通过四个对象查询
	public Page<Customer> selectPageByQueryVo(QueryVo vo){

		Page<Customer> page = new Page<Customer>();
		System.out.println(page);
		System.out.println(vo);
		vo.setSize(5);
		page.setSize(5);
		//判断当前页
		if(null != vo){
			if(null != vo.getPage()){
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());
			}
			if(null != vo.getCustName() && !"".equals(vo.getCustName().trim())){
				vo.setCustName(vo.getCustName().trim());
			}
			if(null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())){
				vo.setCustSource(vo.getCustSource().trim());
			}
			if(null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())){
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if(null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())){
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			
			//装配page后返回
			page.setTotal(customerDao.customerCount(vo));
			page.setRows(customerDao.selectCustomerListByQueryVo(vo));
			
			
		}
		System.out.println(page);
		System.out.println(vo);
		return page;
		
	}
	
	public Customer selectCustomerById(Integer id){
		return customerDao.selectCustomerById(id);
	}
	
	 public void updateCustomerById(Customer customer){
		 
		  customerDao.updateCustomerById(customer);
	 }
	 
	 //通过ID删除用户
	 public void deleteCustomerById(Integer id){
		 customerDao.deleteCustomerById(id);
	 }
	
}
