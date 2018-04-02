package com.wanle.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * 
 **/
public class OrderEmailConfig implements java.io.Serializable {


  private static final long serialVersionUID = 1L;


  @ApiModelProperty("")

  private Integer id;


  @ApiModelProperty("邮件接收人")

  private String emailAlertPerson;


  @ApiModelProperty("邮件标题")

  private String emailTitleSubject;


  @ApiModelProperty("邮件 html模板")

  private String emailHtmlTemplate;




  public void setId(Integer id) { 
  }


  public Integer getId() { 
  }


  public void setEmailAlertPerson(String emailAlertPerson) { 
  }


  public String getEmailAlertPerson() { 
  }


  public void setEmailTitleSubject(String emailTitleSubject) { 
  }


  public String getEmailTitleSubject() { 
  }


  public void setEmailHtmlTemplate(String emailHtmlTemplate) { 
  }


  public String getEmailHtmlTemplate() { 
  }

}