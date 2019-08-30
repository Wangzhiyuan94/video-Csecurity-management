package com.itheima.crm.mapper;


import java.util.List;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerDao {

	
	//总条数
	public Integer customerCount(QueryVo vo);
	//结果集
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	
	//通过ID查询客户
	 public Customer selectCustomerById(Integer id);
	 
	 //通过ID修改客户
	 public void updateCustomerById(Customer customer);
	 
	 
	 //通过ID删除客户
	 public void deleteCustomerById(Integer id);
}
