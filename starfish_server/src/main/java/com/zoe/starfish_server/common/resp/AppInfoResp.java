package com.zoe.starfish_server.common.resp;

public class AppInfoResp {

    //我的未处理预约记录数量
    private int bookedCount;

    //我的收藏：房源
    private int collectHouseCount;

    //我的收藏：资讯
    private int collectNewsCount;


    //未读消息数
    private int unreadMsgCount;

    //是否开启消息
    private boolean openMsg;

    @Override
    public String toString() {
        return "AppInfoResp{" +
                "bookedCount=" + bookedCount +
                ", collectHouseCount=" + collectHouseCount +
                ", collectNewsCount=" + collectNewsCount +
                ", unreadMsgCount=" + unreadMsgCount +
                ", openMsg=" + openMsg +
                '}';
    }

    public boolean isOpenMsg() {
        return openMsg;
    }

    public void setOpenMsg(boolean openMsg) {
        this.openMsg = openMsg;
    }

    public int getBookedCount() {
        return bookedCount;
    }

    public void setBookedCount(int bookedCount) {
        this.bookedCount = bookedCount;
    }

    public int getCollectHouseCount() {
        return collectHouseCount;
    }

    public void setCollectHouseCount(int collectHouseCount) {
        this.collectHouseCount = collectHouseCount;
    }

    public int getCollectNewsCount() {
        return collectNewsCount;
    }

    public void setCollectNewsCount(int collectNewsCount) {
        this.collectNewsCount = collectNewsCount;
    }

    public int getUnreadMsgCount() {
        return unreadMsgCount;
    }

    public void setUnreadMsgCount(int unreadMsgCount) {
        this.unreadMsgCount = unreadMsgCount;
    }
}
