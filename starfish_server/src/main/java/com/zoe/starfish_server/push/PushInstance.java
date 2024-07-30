package com.zoe.starfish_server.push;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoe.starfish_server.utils.OkHttpUtils;
import okhttp3.Call;
import okhttp3.Response;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.io.IOException;
import java.util.Map;

public class PushInstance {

    private final static PushInstance instance = new PushInstance();

    public PushInstance getInstance() {
        return instance;
    }

    public Boolean pushMessage(String deviceToken, Map<String, String> paramMap, Map<String, String> extraMap) {
        NotificationRequest request = NotificationRequest.buildNotification(deviceToken, paramMap, extraMap);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String jsonParam = "";

        try {
            jsonParam = mapper.writeValueAsString(request);
        } catch (JsonProcessingException exception) {
            jsonParam = "";
        }
        OkHttpUtils.getInstance().postFroJson(PushConfig.getRequestUrl("/api/send"), jsonParam, new OkHttpUtils.Callback() {
            @Override
            public void onSuccess(Call call, Object data) {
                try {
                    Response execute = call.execute();
                    String string = execute.body().string();
                    System.out.println("deviceToken= " + deviceToken + " ，发送推送返回：" + string);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onError(Call call, int code, String errorMsg) {

            }

            @Override
            public void onSuccess(Call call, String response) {

            }
        });

        return true;
    }

}
