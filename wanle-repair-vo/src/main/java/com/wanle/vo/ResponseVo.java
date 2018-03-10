package com.wanle.vo;

/**
 * Created by ningyijie on 2018/3/3.
 */
public class ResponseVo<T> {

    private int  code;
    private String msg;
    private T result;


    public ResponseVo(Message message){
        this.code=message.getCode();
        this.msg=message.getMessage();
    }

   public ResponseVo(Message message,T result){
       this.code=message.getCode();
       this.msg=message.getMessage();
       this.result=result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseVo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
