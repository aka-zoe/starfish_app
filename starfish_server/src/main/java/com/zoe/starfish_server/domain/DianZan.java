package com.zoe.starfish_server.domain;

public class DianZan {
    private Long id;

    private Integer type;

    private Long createtime;

    private Long createby;

    private Long newsid;

    private Long pinglunid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getCreateby() {
        return createby;
    }

    public void setCreateby(Long createby) {
        this.createby = createby;
    }

    public Long getNewsid() {
        return newsid;
    }

    public void setNewsid(Long newsid) {
        this.newsid = newsid;
    }

    public Long getPinglunid() {
        return pinglunid;
    }

    public void setPinglunid(Long pinglunid) {
        this.pinglunid = pinglunid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", createtime=").append(createtime);
        sb.append(", createby=").append(createby);
        sb.append(", newsid=").append(newsid);
        sb.append(", pinglunid=").append(pinglunid);
        sb.append("]");
        return sb.toString();
    }
}