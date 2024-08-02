package com.zoe.starfish_server.domain;

public class AppConfig {
    private Long id;

    private String umHost;

    private String umAppMasterSecret;

    private String umAppKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUmHost() {
        return umHost;
    }

    public void setUmHost(String umHost) {
        this.umHost = umHost;
    }

    public String getUmAppMasterSecret() {
        return umAppMasterSecret;
    }

    public void setUmAppMasterSecret(String umAppMasterSecret) {
        this.umAppMasterSecret = umAppMasterSecret;
    }

    public String getUmAppKey() {
        return umAppKey;
    }

    public void setUmAppKey(String umAppKey) {
        this.umAppKey = umAppKey;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", umHost=").append(umHost);
        sb.append(", umAppMasterSecret=").append(umAppMasterSecret);
        sb.append(", umAppKey=").append(umAppKey);
        sb.append("]");
        return sb.toString();
    }
}