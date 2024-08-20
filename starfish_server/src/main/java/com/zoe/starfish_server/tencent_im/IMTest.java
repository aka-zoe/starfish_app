package com.zoe.starfish_server.tencent_im;

import com.zoe.starfish_server.utils.OkHttpUtils;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class IMTest {

    public static void main(String[] args) {
        IMTest test = new IMTest();
        test.test();
    }

    public void test() {
        try {
            JSONObject json = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonItem = new JSONObject();
            jsonItem.put("UserID", "zoe");
            jsonArray.put(jsonItem);
            json.put("CheckItem", jsonArray);
            OkHttpUtils.getInstance().postFroJson("https://console.tim.qq.com" + generateUrl(), json.toString(), new OkHttpUtils.Callback() {
                @Override
                public void onSuccess(Call call, Object data) {
                    try {
                        Response execute = call.execute();
                        String string = execute.body().string();
                        System.out.println("返回：" + string);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override
                public void onError(Call call, int code, String errorMsg) {
                    System.out.println(errorMsg);
                }

                @Override
                public void onSuccess(Call call, String response) {
                    System.out.println(response);
                }
            });

        } catch (Exception e) {


        }
    }

    public String generateUrl() {
        TLSSigAPIv2 tlsSigAPIv2 = new TLSSigAPIv2(1600049996, "a48e36d57a381aa27260ed545ac8cd4c6c8e5b68e3273000d1388a25af840100");
        String sig = tlsSigAPIv2.genUserSig("administrator", 86400);
        String url = "/v4/im_open_login_svc/account_check?sdkappid=1600049996&identifier=administrator&usersig=" + sig + "&random=99999999&contenttype=json";
        return url;
    }
}
