package com.wanle.domain;

import io.swagger.annotations.ApiModelProperty;import java.util.Date;


/**
 * 
 * 后台管理用户
 * 
 **/
public class UserAdmin implements java.io.Serializable {


  private static final long serialVersionUID = 1L;


  @ApiModelProperty("")

  private Integer id;


  @ApiModelProperty("用户名")

  private String name;


  @ApiModelProperty("密码")

  private String password;


  @ApiModelProperty("用户角色")

  private Integer role;


  @ApiModelProperty("1、男  2女")

  private Integer sex;


  @ApiModelProperty("手机号")

  private String mobile;


  @ApiModelProperty("邮箱号")

  private String email;


  @ApiModelProperty("创建时间")

  private Date createTime;


  @ApiModelProperty("更新时间")

  private Date updateTime;




  public void setId(Integer id) { 
  }


  public Integer getId() { 
  }


  public void setName(String name) { 
  }


  public String getName() { 
  }


  public void setPassword(String password) { 
  }


  public String getPassword() { 
  }


  public void setRole(Integer role) { 
  }


  public Integer getRole() { 
  }


  public void setSex(Integer sex) { 
  }


  public Integer getSex() { 
  }


  public void setMobile(String mobile) { 
  }


  public String getMobile() { 
  }


  public void setEmail(String email) { 
  }


  public String getEmail() { 
  }


  public void setCreateTime(Date createTime) { 
  }


  public Date getCreateTime() { 
  }


  public void setUpdateTime(Date updateTime) { 
  }


  public Date getUpdateTime() { 
  }

}