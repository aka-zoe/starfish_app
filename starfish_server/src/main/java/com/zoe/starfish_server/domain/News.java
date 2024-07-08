package com.zoe.starfish_server.domain;

public class News {
    private Long id;

    private String title;

    private String subtitle;

    private Integer type;

    private String tag;

    private Integer dianzan;

    private Integer pinglun;

    private String imageurl;

    private String contenturl;

    private Integer createtime;

    private Integer operationtime;

    private Integer createby;

    private Integer editby;

    private Integer status;

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

    public Integer getDianzan() {
        return dianzan;
    }

    public void setDianzan(Integer dianzan) {
        this.dianzan = dianzan;
    }

    public Integer getPinglun() {
        return pinglun;
    }

    public void setPinglun(Integer pinglun) {
        this.pinglun = pinglun;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getContenturl() {
        return contenturl;
    }

    public void setContenturl(String contenturl) {
        this.contenturl = contenturl;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Integer getOperationtime() {
        return operationtime;
    }

    public void setOperationtime(Integer operationtime) {
        this.operationtime = operationtime;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Integer getEditby() {
        return editby;
    }

    public void setEditby(Integer editby) {
        this.editby = editby;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", subtitle=").append(subtitle);
        sb.append(", type=").append(type);
        sb.append(", tag=").append(tag);
        sb.append(", dianzan=").append(dianzan);
        sb.append(", pinglun=").append(pinglun);
        sb.append(", imageurl=").append(imageurl);
        sb.append(", contenturl=").append(contenturl);
        sb.append(", createtime=").append(createtime);
        sb.append(", operationtime=").append(operationtime);
        sb.append(", createby=").append(createby);
        sb.append(", editby=").append(editby);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}