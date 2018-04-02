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




  public void setId(Integer id) {     this.id = id;
  }


  public Integer getId() {     return this.id;
  }


  public void setEmailAlertPerson(String emailAlertPerson) {     this.emailAlertPerson = emailAlertPerson;
  }


  public String getEmailAlertPerson() {     return this.emailAlertPerson;
  }


  public void setEmailTitleSubject(String emailTitleSubject) {     this.emailTitleSubject = emailTitleSubject;
  }


  public String getEmailTitleSubject() {     return this.emailTitleSubject;
  }


  public void setEmailHtmlTemplate(String emailHtmlTemplate) {     this.emailHtmlTemplate = emailHtmlTemplate;
  }


  public String getEmailHtmlTemplate() {     return this.emailHtmlTemplate;
  }

}
