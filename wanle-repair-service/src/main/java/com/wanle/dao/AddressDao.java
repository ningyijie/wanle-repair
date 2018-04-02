package com.wanle.dao;

import java.util.List;
import com.wanle.domain.Address;
import com.wanle.utils.CommonQueryBean;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * Address数据库操作接口类
 * 
 **/

@Repository
public interface AddressDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Address  selectByPrimaryKey ( @Param("id") Integer id );

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
	int insert( Address record );

	/**
	 *
	 * 添加
	 *
	 **/
	int insertSelective( Address record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( Address record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<Address> list4Page (@Param("record") Address record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	long count (@Param("record") Address record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<Address> list (@Param("record") Address record);

}