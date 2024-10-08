package com.vn.sbit.idenfity_service.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

//thong bao cho json biet rang nhung request body nao null thi se khong hien thi vao
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse <T>{
    private int code;
    private String message;
    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
