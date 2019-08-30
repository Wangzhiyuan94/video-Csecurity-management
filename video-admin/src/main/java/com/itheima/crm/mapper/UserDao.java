package com.itheima.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.itheima.crm.pojo.Role;
import com.itheima.crm.pojo.User;



public interface UserDao {

	public User queryByNameAndPwd(@Param("name")String name,@Param("pwd")String pwd);
	
	
	public List<User> findByUsername(String username);
	
	public void save(User user);
	
	public boolean checkUsername(String word);

	public List<User> findAll();
	
	@Select("select * from user where id=#{id}")
	@Results({
		@Result(id = true,property="id", column = "id"),
		@Result(property="name", column = "name"),
		@Result(property="status", column = "status"),
		@Result(property="user_sex", column = "user_sex"),
		@Result(property="user_email", column = "user_email"),
		@Result(property="user_tel", column = "user_tel"),
		@Result(property="user_birthday", column = "user_birthday"),
		@Result(property="roles", column="id", javaType = java.util.List.class, many = @Many(select="com.itheima.crm.mapper.RoleDao.findRoleByUserId"))
		
	})
	public User findById (String id);
	
	@Select("select * from role where id not in(select rid from user_role where uid = #{userId})")
	public List<Role> findOtherRoles(String userId);


	@Insert("insert into user_role(uid,rid) values(#{userId},#{roleId})")
	public void addRoleToUser(@Param("userId")String userId,@Param("roleId")String roleId);

	@Delete("delete from user where id=#{userid}")
	public void deleteById(String userid);
	
}
