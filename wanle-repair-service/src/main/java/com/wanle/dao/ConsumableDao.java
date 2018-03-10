package com.wanle.dao;

import java.util.List;
import com.wanle.domain.Consumable;
import com.wanle.utils.CommonQueryBean;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * Consumable数据库操作接口类
 * 
 **/

@Repository
public interface ConsumableDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Consumable  selectByPrimaryKey ( @Param(" id") Long  id );

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
	int insert( Consumable record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( Consumable record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<Consumable> list4Page (@Param("record") Consumable record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	long count (@Param("record") Consumable record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<Consumable> list (@Param("record") Consumable record);

}