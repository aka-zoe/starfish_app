package com.zoe.starfish_server.domain;

public class BookedHouse {
    private Long id;

    private Long houseresid;

    private Long bookedtime;

    private Long userid;

    private Long bookeduserid;

    private String userphone;

    private String username;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHouseresid() {
        return houseresid;
    }

    public void setHouseresid(Long houseresid) {
        this.houseresid = houseresid;
    }

    public Long getBookedtime() {
        return bookedtime;
    }

    public void setBookedtime(Long bookedtime) {
        this.bookedtime = bookedtime;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getBookeduserid() {
        return bookeduserid;
    }

    public void setBookeduserid(Long bookeduserid) {
        this.bookeduserid = bookeduserid;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        sb.append(", houseresid=").append(houseresid);
        sb.append(", bookedtime=").append(bookedtime);
        sb.append(", userid=").append(userid);
        sb.append(", bookeduserid=").append(bookeduserid);
        sb.append(", userphone=").append(userphone);
        sb.append(", username=").append(username);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}