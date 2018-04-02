package com.wanle.dao;

import java.util.List;
import com.wanle.domain.EmailSecutity;
import com.wanle.utils.CommonQueryBean;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 
 * EmailSecutity数据库操作接口类
 * 
 **/

@Repository
public interface EmailSecutityDao{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	EmailSecutity  selectByPrimaryKey ( @Param("id") Integer id );

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
	int insert( EmailSecutity record );
	/**
	 *
	 * 添加
	 *
	 **/
	int insertSelective( EmailSecutity record );

	/**
	 *
	 * 修改 （匹配有值的字段）
	 *
	 **/
	int updateByPrimaryKeySelective( EmailSecutity record );

	/**
	 *
	 * list分页查询
	 *
	 **/
	List<EmailSecutity> list4Page (@Param("record") EmailSecutity record, @Param("commonQueryParam") CommonQueryBean query);

	/**
	 *
	 * count查询
	 *
	 **/
	long count (@Param("record") EmailSecutity record);

	/**
	 *
	 * list查询
	 *
	 **/
	List<EmailSecutity> list (@Param("record") EmailSecutity record);

	EmailSecutity selectByEmailAnd5Minute(@Param("email") String email);

}