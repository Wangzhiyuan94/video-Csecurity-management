package com.itheima.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itheima.crm.pojo.Permissions;
import com.itheima.crm.pojo.Role;

public interface PermissionDao {

	
	@Select("select * from permission where id in(select pid from role_permission where rid = #{id})")
	public List<Permissions> findPermissionByRoleId(String id);
	
	@Select("select * from permission")
	public List<Permissions> findAll();
	 
	@Insert("insert into permission values(#{id},#{permissionName},#{url})") 
	public void save(Permissions permissions);
}
