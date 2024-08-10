package com.zoe.starfish_server.common.resp;

/**
 * 我的预约记录
 */
public class BookedListResp {
    private Long id;

    private Long bookedtime;

    private String houseName;

    private Integer status;

    @Override
    public String toString() {
        return "BookedListResp{" +
                "id=" + id +
                ", bookedtime=" + bookedtime +
                ", houseName='" + houseName + '\'' +
                ", status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookedtime() {
        return bookedtime;
    }

    public void setBookedtime(Long bookedtime) {
        this.bookedtime = bookedtime;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
