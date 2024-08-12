package com.zoe.starfish_server.common.resp;

import java.util.List;

public class NewsResp {
    private Long id;

    private String title;

    private String subtitle;

    private Integer type;

    private String tag;

    private Long dianzan;

    private Long pinglun;

    private String contenturl;

    private Long createtime;

    private Long operationtime;

    private Long createby;

    private Long editby;

    private Integer status;

    private List<String> imageList;

    private boolean collected;

    @Override
    public String toString() {
        return "NewsResp{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", type=" + type +
                ", tag='" + tag + '\'' +
                ", dianzan=" + dianzan +
                ", pinglun=" + pinglun +
                ", contenturl='" + contenturl + '\'' +
                ", createtime=" + createtime +
                ", operationtime=" + operationtime +
                ", createby=" + createby +
                ", editby=" + editby +
                ", status=" + status +
                ", imageList=" + imageList +
                ", collected=" + collected +
                '}';
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getDianzan() {
        return dianzan;
    }

    public void setDianzan(Long dianzan) {
        this.dianzan = dianzan;
    }

    public Long getPinglun() {
        return pinglun;
    }

    public void setPinglun(Long pinglun) {
        this.pinglun = pinglun;
    }

    public String getContenturl() {
        return contenturl;
    }

    public void setContenturl(String contenturl) {
        this.contenturl = contenturl;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(Long operationtime) {
        this.operationtime = operationtime;
    }

    public Long getCreateby() {
        return createby;
    }

    public void setCreateby(Long createby) {
        this.createby = createby;
    }

    public Long getEditby() {
        return editby;
    }

    public void setEditby(Long editby) {
        this.editby = editby;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }
}
