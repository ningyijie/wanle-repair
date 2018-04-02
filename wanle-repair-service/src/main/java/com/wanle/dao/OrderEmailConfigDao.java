package com.wanle.dao;

import java.util.List;
import com.wanle.domain.OrderEmailConfig;
import com.wanle.utils.CommonQueryBean;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * OrderEmailConfig数据库操作接口类
 * 
 **/

@Repository
public interface OrderEmailConfigDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	OrderEmailConfig  selectByPrimaryKey ( @Param("id") Integer id );

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
	int insert( OrderEmailConfig record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( OrderEmailConfig record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<OrderEmailConfig> list4Page (@Param("record") OrderEmailConfig record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	long count (@Param("record") OrderEmailConfig record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<OrderEmailConfig> list (@Param("record") OrderEmailConfig record);

}