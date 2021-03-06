package com.gtmdtest.platform.model.enums;

/**
 * @program: platform
 * @description:
 * @author:
 * @create: 2019-11-25 13:05
 **/
public enum  BaseResponseEnums {
    SUCCESS(0,"success"),
    FAIL(1,"fail"),
    ERROR(-1,"error");

    int code;
    String message;

    BaseResponseEnums(int code, String message) {

        this.code = code;
        this.message = message;
    }

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
}
