package com.zoe.starfish_server.domain;

public class PingLun {
    private Long id;

    private Integer type;

    private Long dianzan;

    private Long createtime;

    //提交评论的人
    private Long createby;

    private Long newsid;

    //被评论人
    private Long userid;

    private Long pinglunid;

    private String content;

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

    public Long getDianzan() {
        return dianzan;
    }

    public void setDianzan(Long dianzan) {
        this.dianzan = dianzan;
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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getPinglunid() {
        return pinglunid;
    }

    public void setPinglunid(Long pinglunid) {
        this.pinglunid = pinglunid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", dianzan=").append(dianzan);
        sb.append(", createtime=").append(createtime);
        sb.append(", createby=").append(createby);
        sb.append(", newsid=").append(newsid);
        sb.append(", userid=").append(userid);
        sb.append(", pinglunid=").append(pinglunid);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }
}
