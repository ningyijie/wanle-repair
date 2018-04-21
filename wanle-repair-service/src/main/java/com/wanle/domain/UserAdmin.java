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




  public void setId(Integer id) {     this.id = id;
  }


  public Integer getId() {     return this.id;
  }


  public void setName(String name) {     this.name = name;
  }


  public String getName() {     return this.name;
  }


  public void setPassword(String password) {     this.password = password;
  }


  public String getPassword() {     return this.password;
  }


  public void setRole(Integer role) {     this.role = role;
  }


  public Integer getRole() {     return this.role;
  }


  public void setSex(Integer sex) {     this.sex = sex;
  }


  public Integer getSex() {     return this.sex;
  }


  public void setMobile(String mobile) {     this.mobile = mobile;
  }


  public String getMobile() {     return this.mobile;
  }


  public void setEmail(String email) {     this.email = email;
  }


  public String getEmail() {     return this.email;
  }


  public void setCreateTime(Date createTime) {     this.createTime = createTime;
  }


  public Date getCreateTime() {     return this.createTime;
  }


  public void setUpdateTime(Date updateTime) {     this.updateTime = updateTime;
  }


  public Date getUpdateTime() {     return this.updateTime;
  }

}
