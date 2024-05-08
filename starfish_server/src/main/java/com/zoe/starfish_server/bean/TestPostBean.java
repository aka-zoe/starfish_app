package com.zoe.starfish_server.bean;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TestPostBean {
    @NonNull
    private String name;
    @NonNull
    private String age;

    @NonNull
    private String address;
}
