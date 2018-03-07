package com.wanle.dao;

import java.util.List;
import com.wanle.domain.PhoneType;
import com.wanle.utils.CommonQueryBean;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * PhoneType数据库操作接口类
 * 
 **/

@Repository
public interface PhoneTypeDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	PhoneType  selectByPrimaryKey ( @Param("id") Long id );

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
	int insert( PhoneType record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( PhoneType record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<PhoneType> list4Page (@Param("record") PhoneType record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	long count (@Param("record") PhoneType record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<PhoneType> list (@Param("record") PhoneType record);

}