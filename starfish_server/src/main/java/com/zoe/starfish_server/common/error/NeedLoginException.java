package com.zoe.starfish_server.common.error;

import com.zoe.starfish_server.common.RespCodeEnum;

public class NeedLoginException extends RuntimeException{
    private RespCodeEnum code;

    public NeedLoginException(RespCodeEnum code) {
        this.code = code;
    }

    /**
     * 不写入堆栈信息，提高性能
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
