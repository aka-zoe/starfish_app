package com.zoe.starfish_server.common.resp;

import com.zoe.starfish_server.common.RespCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回数据实体
 *
 * @param <T>
 */
@Data
public class CommonResp<T> {
    //返回失败时，返回的错误信息
    private String message;

    //返回的code
    private int code;

    //返回成功的时候，返回的内容
    private T content;

    //请求状态
    private boolean success;


    public CommonResp() {
    }

    public CommonResp(String message, int code, T content, boolean success) {
        this.message = message;
        this.code = code;
        this.content = content;
        this.success = success;
    }

    public static CommonResp errorMsg(RespCodeEnum code, String message) {
        CommonResp commonResp = new CommonResp(code.getMessage(), code.getCode(), null, false);
        commonResp.setMessage(message);
        return commonResp;
    }

    public static CommonResp error(RespCodeEnum code) {
        return new CommonResp(code.getMessage(), code.getCode(), null, false);
    }

    public static CommonResp success(Object content) {
        return new CommonResp("success", 200, content, true);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
