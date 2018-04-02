package com.wanle.domain;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


public class EmailSecutity implements java.io.Serializable {


  private static final long serialVersionUID = 1L;


  @ApiModelProperty("")

  private Integer id;


  @ApiModelProperty("邮件验证码")

  private String securityCode;


  @ApiModelProperty("邮件")

  private String email;


  @ApiModelProperty("添加时间")

  private Date insertTime;




  public void setId(Integer id) { 
    this.id = id;
  }


  public Integer getId() { 
    return this.id;
  }


  public void setSecurityCode(String securityCode) { 
    this.securityCode = securityCode;
  }


  public String getSecurityCode() { 
    return this.securityCode;
  }


  public void setEmail(String email) { 
    this.email = email;
  }


  public String getEmail() { 
    return this.email;
  }


  public void setInsertTime(Date insertTime) { 
    this.insertTime = insertTime;
  }


  public Date getInsertTime() { 
    return this.insertTime;
  }

}
