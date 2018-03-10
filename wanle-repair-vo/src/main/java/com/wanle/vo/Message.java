package com.wanle.vo;

/**
 * Created by ningyijie on 2018/3/3.
 */
public enum Message {

    Success(200, "操作成功"),
    ParamError(400, "参数错误"),
    SystemError(500, "系统异常错误"),
    UnKnowError(501, "未知错误"),
    NoResult(801, "没有返回结果");


    Message(int code,String message){
        this.code=code;
        this.message=message;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private Integer code;
    private String message;

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
