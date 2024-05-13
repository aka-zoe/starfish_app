package com.zoe.starfish_server.common.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回数据实体
 *
 * @param <T>
 */
@Data
public class CommonResp<T> {
    public static String errorMsg = "error";
    public static String successMsg = "success";
    public static int rspCode = 0;


    /**
     * 返回是否成功
     */
    private boolean isSuccess = true;

    /**
     * 返回失败时，返回的错误信息
     */
    private String message;

    private int code = 0;

    /**
     * 返回成功的时候，返回的内容
     */
    private T content;

    public CommonResp() {
    }

    public CommonResp(boolean isSuccess, String message, T content, int code) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.content = content;
        this.code = code;
    }

    public static String getErrorMsg() {
        return errorMsg;
    }

    public static void setErrorMsg(String errorMsg) {
        CommonResp.errorMsg = errorMsg;
    }

    public static String getSuccessMsg() {
        return successMsg;
    }

    public static void setSuccessMsg(String successMsg) {
        CommonResp.successMsg = successMsg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static CommonResp errorRsp() {
        return new CommonResp(false, errorMsg, null, -1);
    }

    public static CommonResp errorRsp(String errorMsg, int code) {
        return new CommonResp(false, errorMsg, null, code);
    }

    public static CommonResp successRsp(Object result) {
        return new CommonResp(true, successMsg, result, rspCode);
    }
}
