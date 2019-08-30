package com.itheima.crm.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.mapper.UserDao;
import com.itheima.crm.pojo.Role;
import com.itheima.crm.pojo.User;

@Service("userService")
@Transactional
public class UserDetailsServiceImpl implements IUserService {

	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		User userInfo = null;
		
		List<User> users = userDao.findByUsername(username);
		if(null!=users&& users.size()>0 && null!=users.get(0)){
			 userInfo = users.get(0);
			 
			 System.out.println(users);
			 if(null != userInfo.getRoles()&&userInfo.getRoles().size()>0&&null!=userInfo.getRoles().get(0)){
				 
				 for (User user : users) {
					 
					 userInfo.getRoles().add(user.getRoles().get(0));	
				 }
				userInfo.getRoles().remove(0); 
			 }
		}
		System.out.println(userInfo);
		
		//处理自己的用户对象封装成UserDetails
		/*org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(userInfo.getName(),userInfo.getPassword(),getAuthority(userInfo.getRoles()));*/
		org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User( userInfo.getName(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
		return user1;

	}
	//返回一个List集合 集合中装入权限集合
	public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
		
		
		List<SimpleGrantedAuthority> list = new ArrayList<>();
		for(Role role:roles)
		{
			list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));	
		}
		System.out.println(list);
		return list;
	}
	

}
