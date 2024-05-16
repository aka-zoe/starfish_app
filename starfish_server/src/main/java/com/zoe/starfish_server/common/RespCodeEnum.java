package com.zoe.starfish_server.common;

public enum RespCodeEnum {
    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    SYSERR(202, "系统错误"),
    PARAMERR(203, "参数校验失败"),
    EMPTYDATA(204, "数据为空"),
    ALREADYEXIST(204, "数据已存在"),
    AUTHERROR(205, "没有此用户或者密码错误"),
    SAMEUSER(206, "用户已存在"),
    BUSINESSERR(207, "业务异常"),
    UPLOADFILEERR(208, "文件上传失败"),
    SOCKETSENDERR(209, "Socket 发送失败");

    private Integer code;

    private String message;

    private RespCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
