package com.zoe.starfish_server.common.error;

import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 统一异常处理、数据预处理等
 * 该类用于捕获系统弹出的异常
 * 将异常包装成一个 CommonResp
 * 从而方便前端调用，显示错误信息
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 校验异常统一处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public CommonResp validExceptionHandler(BindException e) {
        LOG.warn("参数校验失败：{}", e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return CommonResp.errorMsg(RespCodeEnum.PARAMERR, e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    /**
     * 校验异常统一处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public CommonResp validExceptionHandler(BusinessException e) {
        LOG.warn("业务异常：{}", e.getCode().getDesc());
        return CommonResp.errorMsg(RespCodeEnum.BUSINESSERR, e.getCode().getDesc());
    }

    /**
     * 需要登录
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = NeedLoginException.class)
    @ResponseBody
    public CommonResp validExceptionHandler(NeedLoginException e) {
        return CommonResp.error(RespCodeEnum.NEEDLOGIN);
    }

    /**
     * 校验异常统一处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResp validExceptionHandler(Exception e) {
        LOG.error("系统异常：", e);
        return CommonResp.errorMsg(RespCodeEnum.SYSERR, e.getMessage());
    }
}

