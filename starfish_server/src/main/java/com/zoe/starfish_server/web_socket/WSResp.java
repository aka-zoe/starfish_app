package com.zoe.starfish_server.web_socket;

import lombok.*;

import java.io.Serializable;
@Getter
@Builder
@NoArgsConstructor
@Data
public class WSResp<T> implements Serializable {
    private static final long serialVersionUID = -6451812593150428369L;

    public static class WSRespCode {
        public static int connectCode = 200;
        public static int uploadCode = 666;
        public static int heartBeat = 333;

    }

    private int code;
    private String message;

    private T body;

    public WSResp(int code, String message, T body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public static WSResp success(int code, Object body) {
        return new WSResp(code, "", body);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "WSResp{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", body=" + body +
                '}';
    }
}
