package com.zoe.starfish_server.tencent_im;

import com.zoe.starfish_server.utils.OkHttpUtils;
import com.zoe.starfish_server.utils.thread_pool.ThreadPoolUtils;
import okhttp3.Call;
import org.json.JSONObject;


public class IMInstance {

    private final static IMInstance instance = new IMInstance();

    public static IMInstance getInstance() {
        return instance;
    }

    public void importAccount(String userId, String nick, String headUrl) {
        //在线程池里请求
        ThreadPoolUtils.getNewInstance().executor(() -> {
            importAccountForIM(userId, nick, headUrl);
        });
    }

    private void importAccountForIM(String userId, String nick, String headUrl) {
        String url = IMConfigInfo.generateUrl("v4/im_open_login_svc/account_import");
        String json = IMConfigInfo.importAccountJson(userId, nick, headUrl);
        requestForIM("importAccountForIM", url, json);
    }

    public static void main(String[] args) {

    }

    private void requestForIM(String logTag, String url, String json) {
        try {
            OkHttpUtils.getInstance().postFroJson(url, json, new OkHttpUtils.Callback() {
                @Override
                public void onSuccess(Call call, Object data) {
                    try {
                        JSONObject responseJson = getResponseJson(call);
                        System.out.println("onSuccess 请求：" + logTag + "，返回：" + responseJson);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override
                public void onError(Call call, int code, String errorMsg) {
                    System.out.println("onError 请求：" + logTag + "，返回：" + errorMsg);
                }

                @Override
                public void onSuccess(Call call, String response) {
                    System.out.println("onSuccess 请求：" + logTag + "，返回：" + response);
                }
            });

        } catch (Exception e) {
            System.out.println("异常 请求：" + logTag + "，返回：" + e);
        }
    }

}
