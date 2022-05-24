package com.example.Day3.model;

import lombok.AllArgsConstructor;

public class ResponseAPI {

    private String msg;
    private Integer status;
    private String errorMesaage;

    public ResponseAPI(String msg, Integer status, String errorMesaage) {
        this.msg = msg;
        this.status = status;
        this.errorMesaage = errorMesaage;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorMesaage() {
        return errorMesaage;
    }

    public void setErrorMesaage(String errorMesaage) {
        this.errorMesaage = errorMesaage;
    }
}
