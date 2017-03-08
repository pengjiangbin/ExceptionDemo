package com.padoon.exceptiondemo.api.exception;

/**
 * Created by jiang on 2017/2/23.
 */

public enum ApiError {
    ERROR_REQUEST_PARAM(0, "登录错误"),
    USER_NOT_EXIST(1, "用户不存在"),
    ERROR_CHARGE(2, "充值失败"),
    ERROR_REQUEST(3, "非法请求"),
    ERROR_NET_CONNECTION(4, "注册错误");
    private int errorCode;
    private String errorMessage;

    ApiError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static String getErrorMessage(int errorCode) {
        String errorDesc = "系统错误";
        return errorDesc;
    }

}
