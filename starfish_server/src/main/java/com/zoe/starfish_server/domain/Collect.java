package com.zoe.starfish_server.domain;

public class Collect {
    private Long id;

    private Integer collecttype;

    private Long collecttime;

    private Long houseresid;

    private Long newsid;

    private Long userid;

    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCollecttype() {
        return collecttype;
    }

    public void setCollecttype(Integer collecttype) {
        this.collecttype = collecttype;
    }

    public Long getCollecttime() {
        return collecttime;
    }

    public void setCollecttime(Long collecttime) {
        this.collecttime = collecttime;
    }

    public Long getHouseresid() {
        return houseresid;
    }

    public void setHouseresid(Long houseresid) {
        this.houseresid = houseresid;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", collecttype=").append(collecttype);
        sb.append(", collecttime=").append(collecttime);
        sb.append(", houseresid=").append(houseresid);
        sb.append(", newsid=").append(newsid);
        sb.append(", userid=").append(userid);
        sb.append(", title=").append(title);
        sb.append("]");
        return sb.toString();
    }
}