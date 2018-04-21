package com.wanle.dao;

import java.util.List;
import com.wanle.domain.UserAdmin;
import com.wanle.utils.CommonQueryBean;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * UserAdmin数据库操作接口类
 * 
 **/

@Repository
public interface UserAdminDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	UserAdmin  selectByPrimaryKey ( @Param("id") Integer id );

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	int deleteByPrimaryKey ( @Param("id") Integer id );

	/**
	 * 
	 * 添加
	 * 
	 **/
	int insert( UserAdmin record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertSelective( UserAdmin record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( UserAdmin record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<UserAdmin> list4Page (@Param("record") UserAdmin record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	long count (@Param("record") UserAdmin record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<UserAdmin> list (@Param("record") UserAdmin record);

}