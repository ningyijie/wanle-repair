package com.wanle.dao;

import java.util.List;
import com.wanle.domain.RepairType;

import com.wanle.utils.CommonQueryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * RepairType数据库操作接口类
 * 
 **/

@Repository
public interface RepairTypeDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	RepairType  selectByPrimaryKey ( @Param(" id") Long  id );

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	int deleteByPrimaryKey ( @Param(" id") Long  id );

	/**
	 * 
	 * 添加
	 * 
	 **/
	int insert( RepairType record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( RepairType record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<RepairType> list4Page (@Param("record") RepairType record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	long count (@Param("record") RepairType record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<RepairType> list (@Param("record") RepairType record);

}