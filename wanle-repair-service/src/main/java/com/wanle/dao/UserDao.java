package com.wanle.dao;

import java.util.List;
import com.wanle.domain.User;
import com.wanle.utils.CommonQueryBean;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * User数据库操作接口类
 * 
 **/

@Repository
public interface UserDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	User  selectByPrimaryKey ( @Param("id") Long id );
	/**
	 *
	 * 查询（根据openid查询）
	 *
	 **/
	User  selectByOpenId ( @Param("openid") String openid );

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	int deleteByPrimaryKey ( @Param("id") Long id );

	/**
	 * 
	 * 添加
	 * 
	 **/
	int insert( User record );
	/**
	 *
	 * 添加
	 *
	 **/
	int insertSelective( User record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( User record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<User> list4Page (@Param("record") User record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	long count (@Param("record") User record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<User> list (@Param("record") User record);



}