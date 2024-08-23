package com.zoe.starfish_server.tencent_im;

import com.zoe.starfish_server.tencent_im.utils.TLSSigAPIv2;
import org.json.JSONObject;

public class IMConfigInfo {
    //IM域名
    public static String TencentHost = "https://console.tim.qq.com/";
    //申请的应用秘钥
    public static String IMSecretKey = "a48e36d57a381aa27260ed545ac8cd4c6c8e5b68e3273000d1388a25af840100";
    //申请的APP id
    public static Long SDKAPPID = 1600049996L;

    //管理员账号，调用IM接口时必须使用管理员账号id
    public static String AdministratorUserId = "administrator";

    /**
     * 拼接请求接口地址，规则见：<a href="https://cloud.tencent.com/document/product/269/1520">接口文档</a>
     *
     * @param url 接口路径
     * @return
     */
    public static String generateUrl(String url) {
        TLSSigAPIv2 tlsSigAPIv2 = new TLSSigAPIv2(SDKAPPID, IMSecretKey);
        String sig = tlsSigAPIv2.genUserSig(AdministratorUserId, 86400);
        url = url + "?sdkappid=" + SDKAPPID + "&identifier=" + AdministratorUserId + "&usersig=" + sig + "&random=99999999&contenttype=json";
        return TencentHost + url;
    }

    /**
     * 导入IM用户参数
     *
     * @param userId
     * @param nick
     * @param headUrl
     * @return
     */
    public static String importAccountJson(String userId, String nick, String headUrl) {
        try {
            JSONObject json = new JSONObject();
            json.put("UserID", userId);
            json.put("Nick", nick);
            json.put("FaceUrl", headUrl);
            return json.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
