package com.zoe.starfish_server.push;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PushConfig {
    //友盟的域名
    public static String UMHost = "https://msgapi.umeng.com";

    //友盟应用注册后的MasterSecret
    public static String APPMasterSecret = "amonmll8fkzbqbab0f7vz5xptyobd3x1";

    //友盟应用注册后的APPKey
    public static String APPKey = "66a64da0192e0574e74d5585";

    //友盟默认的请求方法都是POST，这里拼接秘钥准备
    private static String Method = "POST";

    public static String getRequestUrl(String path) {
        return UMHost + path;
    }


    /**
     * 提取请求方法method（POST，全大写）；
     * <p>
     * 提取请求url信息，包括Host字段的域名(或ip:端口)和URI的path部分。
     * 注意不包括path的querystring。比如http://msg.umeng.com/api/send
     * 或者 http://msg.umeng.com/api/status;
     * <p>
     * 提取请求的post-body；
     * <p>
     * 拼接请求方法、url、post-body及应用的app_master_secret；
     * <p>
     * 将上一步形成的字符串计算MD5值，形成一个32位的十六进制（字母小写）字符串，即为本次请求sign（签名）的值；
     * Sign=MD5(${http_method}${url}${post-body}${app_master_secret})
     *
     * @param url
     * @param postBody
     * @return
     */
    public static String generateSign(String url, String postBody) {
        //组合加密前内容
        String text = Method + url + postBody + APPMasterSecret;

        return computeMD5Signature(text);
    }

    public static String computeMD5Signature(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(data.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
