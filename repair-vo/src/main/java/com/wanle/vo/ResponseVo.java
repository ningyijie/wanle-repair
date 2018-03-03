package com.wanle.vo;

/**
 * Created by ningyijie on 2018/3/3.
 */
public class ResponseVo<T> {

    private Message message;
    private T result;


    public ResponseVo(Message message){
        this.message=message;
    }

   public ResponseVo(Message message,T result){
        this.message=message;
        this.result=result;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
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
                "message=" + message +
                ", result=" + result +
                '}';
    }
}
