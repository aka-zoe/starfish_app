package com.zoe.starfish_server.utils;

import okhttp3.*;


import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class OkHttpUtils {

    private static final String TAG = "OkHttpUtils";

    private static OkHttpUtils mInstance;
    private OkHttpClient mOkHttpClient;

    private OkHttpUtils() {
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

    }

    /**
     * 获取 OkHttpUtils 实例
     */
    public static OkHttpUtils getInstance() {
        if (mInstance == null) {
            synchronized (OkHttpUtils.class) {
                if (mInstance == null) {
                    mInstance = new OkHttpUtils();
                }
            }
        }
        return mInstance;
    }

    /**
     * GET 请求
     */
    public void get(String url, Map<String, String> params, Callback callback) {
        StringBuilder sb = new StringBuilder(url);
        if (params != null && !params.isEmpty()) {
            sb.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        Request request = new Request.Builder()
                .get()
                .url(sb.toString())
                .build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }

    /**
     * POST 请求
     */
    public void post(String url, Map<String, String> params, Callback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        Request request = new Request.Builder()
                .post(builder.build())
                .url(url)
                .build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }

    public void postFroJson(String url,String json, Callback callback){
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }

    /**
     * 上传文件
     */
    public void uploadFile(String url, File file, String fileName, Map<String, String> params, Callback callback) {
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", fileName, RequestBody.create(MediaType.parse("application/octet-stream"), file));
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.addFormDataPart(entry.getKey(), entry.getValue());
            }
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }


    /**
     * 封装 Callback，方便调用
     */
    public abstract static class Callback<T> implements okhttp3.Callback {

        private static final String TAG = "Callback";

        @Override
        public void onFailure(Call call, IOException e) {
            e.printStackTrace();
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            if (response.isSuccessful()) {
                onSuccess(call, response.body().string());
            } else {
                onError(call, response.code(), response.body().string());
            }
            response.close();
        }

        public abstract void onSuccess(Call call, T data);

        public abstract void onError(Call call, int code, String errorMsg);

        public abstract void onSuccess(Call call, String response);

    }
}
