package com.bibi.dnwtd.web.commons;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private T data;
    private Integer code;
    private String desc;

    public Result() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static class Builder<T>{
        private Result<T> result;
        public Builder(T data){
            result = new Result<T>();
            result.setData(data);
        }

        public Builder setCode(Integer code){
            result.setCode(code);
            return this;
        }

        public Builder setDesc(String desc){
            result.setDesc(desc);
            return this;
        }

        public Builder setData(T data){
            result.setData(data);
            return this;
        }

        public Result build(){
            return this.result;
        }
    }
}
