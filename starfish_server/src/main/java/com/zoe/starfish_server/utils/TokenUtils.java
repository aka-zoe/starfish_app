package com.zoe.starfish_server.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    //设置过期时间
    private static final long EXPIRE_DATE = 1000 * 60 * 50; //5分钟过期
    //token秘钥
    private static final String TOKEN_SECRET = "ZCfasfhuaUUHufguGuwu2020BQWf";

    public static String token(String username, String password, Long userId) {

        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username", username)
                    .withClaim("password", password)
                    .withClaim("userId", userId).withExpiresAt(date)
                    .sign(algorithm);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return token;
    }

    public static boolean verify(String token) {
        /**
         * @desc 验证token，通过返回true
         * @params [token]需要校验的串
         **/
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();

            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            System.out.println("校验失败");
            return false;
        }
    }

    /**
     * 从token中获取用户id
     *
     * @param servletRequest
     * @return
     */
    public static Long getUserId(HttpServletRequest servletRequest) {
        try {
            String token = servletRequest.getHeader("token");
            return JWT.decode(token).getClaim("userId").asLong();
        } catch (Exception exception) {
            return -1L;
        }

    }

    public static void main(String[] args) {
        String username = "gongsensen";
        String password = "123456";
        Long userId = 1L;
        String token = token(username, password, userId);
        System.out.println(token);
        boolean b = verify("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsImV4cCI6MTcxNjA0NDI3MiwidXNlcm5hbWUiOiJnb25nc2Vuc2VuIn0.kPZ8tIhHPmEz-9a7N8LdMKdWK9lEyff8URdt9lNOHsY");
        Claim username1 = JWT.decode("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsImV4cCI6MTcxNjA0NDI3MiwidXNlcm5hbWUiOiJnb25nc2Vuc2VuIn0.kPZ8tIhHPmEz-9a7N8LdMKdWK9lEyff8URdt9lNOHsY").getClaim("username");
        System.out.println("我是从token中获取的信息" + username1.asString());

        System.out.println(b);
    }

}
