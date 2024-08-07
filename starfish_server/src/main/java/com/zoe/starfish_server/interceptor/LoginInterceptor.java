package com.zoe.starfish_server.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.error.NeedLoginException;
import com.zoe.starfish_server.domain.User;
import com.zoe.starfish_server.service.UserService;
import com.zoe.starfish_server.utils.PassToken;
import com.zoe.starfish_server.utils.UserLoginToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.zoe.starfish_server.utils.TokenUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        //检查方法是否有passtoken注解，有则跳过认证，直接通过
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
//                    throw new RuntimeException("无token，请重新登录");
                    throw new NeedLoginException(RespCodeEnum.NEEDLOGIN);
                }
                // 获取 token 中的 user id
                String username;
                String password;
                try {
                    username = JWT.decode(token).getClaim("username").asString();
                    password = JWT.decode(token).getClaim("password").asString();
                } catch (JWTDecodeException j) {
//                    throw new RuntimeException("token不正确");
                    throw new NeedLoginException(RespCodeEnum.NEEDLOGIN);
                }
//                log.info("从token里获取username=" + username);
//                log.info("从token里获取password=" + password);
                User user = userService.selectUser(username, password);
                if (user == null) {
//                    throw new RuntimeException("用户不存在，请重新登录");
                    throw new NeedLoginException(RespCodeEnum.NEEDLOGIN);
                }
                // 验证 token
                if (TokenUtils.verify(token)) {
                    return true;
                } else {
//                    throw new RuntimeException("token过期或不正确，请重新登录");
                    throw new NeedLoginException(RespCodeEnum.NEEDLOGIN);
                }

            }
        }
        throw new RuntimeException("没有权限注解一律不通过");
    }

    /**
     * 目标方法执行后
     * 该方法在控制器处理请求方法调用之后、解析视图之前执行
     * 可以通过此方法对请求域中的模型和视图做进一步修改
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {
//        System.out.println("postHandle执行{}");

    }

    /**
     * 页面渲染后
     * 该方法在视图渲染结束后执行
     * 可以通过此方法实现资源清理、记录日志信息等工作
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {
//        System.out.println("afterCompletion执行异常");

    }


}
