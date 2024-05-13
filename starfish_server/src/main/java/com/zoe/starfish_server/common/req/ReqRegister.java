package com.zoe.starfish_server.common.req;

import lombok.*;

@Data
@NoArgsConstructor
@ToString
public class ReqRegister {
    private String name;
    private String password;
    private String rePassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
