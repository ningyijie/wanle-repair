package com.wanle.dao;

import java.util.List;
import com.wanle.domain.Color;

import com.wanle.utils.CommonQueryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * Color数据库操作接口类
 * 
 **/

@Repository
public interface ColorDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Color  selectByPrimaryKey ( @Param("id") Long id );

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
	int insert( Color record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( Color record );

	/**
	 * 
	 * list分页查询
	 * 
	 **/
	List<Color> list4Page (@Param("record") Color record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 * 
	 * count查询
	 * 
	 **/
	long count (@Param("record") Color record);

	/**
	 * 
	 * list查询
	 * 
	 **/
	List<Color> list (@Param("record") Color record);

}