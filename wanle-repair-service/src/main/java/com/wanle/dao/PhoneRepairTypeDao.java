package com.wanle.dao;

import java.util.List;
import com.wanle.domain.PhoneRepairType;
import com.wanle.utils.CommonQueryBean;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * PhoneRepairType数据库操作接口类
 * 
 **/

@Repository
public interface PhoneRepairTypeDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	PhoneRepairType  selectByPrimaryKey ( @Param("id") Integer id );

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
	int insert( PhoneRepairType record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( PhoneRepairType record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<PhoneRepairType> list4Page (@Param("record") PhoneRepairType record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	long count (@Param("record") PhoneRepairType record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<PhoneRepairType> list (@Param("record") PhoneRepairType record);

	PhoneRepairType selectByCondition (@Param("record") PhoneRepairType record);

}