package com.wanle.domain;

import io.swagger.annotations.ApiModelProperty;import java.util.Date;


/**
 * 
 * 
 * 
 **/
public class OrderEmailConfig implements java.io.Serializable {


  private static final long serialVersionUID = 1L;


  @ApiModelProperty("")

  private Integer id;


  @ApiModelProperty("模板名称")

  private String name;


  @ApiModelProperty("邮件接收人")

  private String emailAlertPerson;


  @ApiModelProperty("邮件标题")

  private String emailTitleSubject;


  @ApiModelProperty("邮件 html模板")

  private String emailHtmlTemplate;


  @ApiModelProperty("微信推送人")

  private String wxPushPerson;


  @ApiModelProperty("微信推送模板")

  private String wxPushTemplate;


  @ApiModelProperty("")

  private Date createTime;


  @ApiModelProperty("")

  private Date updateTime;




  public void setId(Integer id) {     this.id = id;
  }


  public Integer getId() {     return this.id;
  }


  public void setName(String name) {     this.name = name;
  }


  public String getName() {     return this.name;
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


  public void setWxPushPerson(String wxPushPerson) {     this.wxPushPerson = wxPushPerson;
  }


  public String getWxPushPerson() {     return this.wxPushPerson;
  }


  public void setWxPushTemplate(String wxPushTemplate) {     this.wxPushTemplate = wxPushTemplate;
  }


  public String getWxPushTemplate() {     return this.wxPushTemplate;
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
