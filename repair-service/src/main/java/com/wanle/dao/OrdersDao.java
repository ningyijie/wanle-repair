package com.wanle.dao;

import com.wanle.domain.Orders;
import com.wanle.utils.CommonQueryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * Orders数据库操作接口类
 * 
 **/

@Repository
public interface OrdersDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Orders  selectByPrimaryKey ( @Param("id") Long id );

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
	int insert( Orders record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( Orders record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<Orders> list4Page (@Param("record") Orders record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	long count (@Param("record") Orders record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<Orders> list (@Param("record") Orders record);

}