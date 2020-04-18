package com.gtmdtest.platform.common.exception;

import cn.hutool.core.util.StrUtil;
/**
 * @program: platform
 * @description:
 * @author:
 * @create: 2019-12-19 16:07
 **/
public class GTMDException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Integer code;
    private String msg;

    public GTMDException(AppErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }
    public GTMDException(AppErrorCode code, Object ...params) {
        this.code = code.getCode();
        this.msg = StrUtil.format(code.getMsg(), params);
    }

    public GTMDException(AppErrorCode code, Throwable e, Object ...params) {
        super(e);
        this.code = code.getCode();
        this.msg = StrUtil.format(code.getMsg(), params);
    }

    public GTMDException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public GTMDException(Integer code, String msg, Throwable e) {
        super(e);
        this.code = code;
        this.msg = msg;
    }


    public GTMDException(String msg) {
        super(msg);
        this.code = AppErrorCode.INTERNAL_SERVER_ERROR.getCode();
        this.msg = msg;
    }

    public GTMDException(String msg, Throwable e) {
        super(msg, e);
        this.code = AppErrorCode.INTERNAL_SERVER_ERROR.getCode();
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
