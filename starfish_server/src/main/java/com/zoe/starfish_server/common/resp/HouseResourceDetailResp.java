package com.zoe.starfish_server.common.resp;

import com.zoe.starfish_server.domain.HouseTag;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 房源明细数据
 */
@Data
@NoArgsConstructor
@ToString
public class HouseResourceDetailResp {
    private Long id;

    //banner图
    private List<String> imageList;

    //说明
    private String houseDesc;

    //租赁类型
    private Integer leaseType;

    //租金
    private Long rent;

    //中介费
    private Long serviceCharge;

    //户型名称
    private String houseTypeName;

    //房源类型
    private Integer houseType;

    //朝向
    private String direction;

    //可入住时间
    private String checkInDate;

    //总楼层
    private Integer totalFloor;

    //当前楼层
    private Integer currentFloor;

    //小区名称
    private String houseArea;

    //面积
    private Integer acreage;

    //发布时间
    private String publishDate;

    //装修类型
    private String fitment;

    //支付类型
    private Integer paymentType;

    //床
    private boolean bed;

    //洗衣机
    private boolean washingMachine;

    //冰箱
    private boolean refrigerator;

    //空调
    private boolean airConditioner;

    //wifi
    private boolean wifi;

    //沙发
    private boolean sofa;

    //桌椅
    private boolean tableChair;

    //电视
    private boolean tv;

    //热水器
    private boolean waterHeater;

    //可做饭
    private boolean cook;

    //暖气
    private boolean heating;

    //阳台
    private boolean balcony;

    //经度
    private String longitude;

    //纬度
    private String latitude;

    //发布人
    private String publisher;

    //发布人电话
    private String publisherNumber;

    //标签列表
    private List<HouseTag> tagList;

    //发布人id
    private Long publisherId;

    //发布人类型
    private String publisherType;

    //发布人头像
    private String publisherHead;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public String getHouseDesc() {
        return houseDesc;
    }

    public void setHouseDesc(String houseDesc) {
        this.houseDesc = houseDesc;
    }

    public Integer getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(Integer leaseType) {
        this.leaseType = leaseType;
    }

    public Long getRent() {
        return rent;
    }

    public void setRent(Long rent) {
        this.rent = rent;
    }

    public Long getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Long serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getHouseTypeName() {
        return houseTypeName;
    }

    public void setHouseTypeName(String houseTypeName) {
        this.houseTypeName = houseTypeName;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Integer currentFloor) {
        this.currentFloor = currentFloor;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public Integer getAcreage() {
        return acreage;
    }

    public void setAcreage(Integer acreage) {
        this.acreage = acreage;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getFitment() {
        return fitment;
    }

    public void setFitment(String fitment) {
        this.fitment = fitment;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public boolean isBed() {
        return bed;
    }

    public void setBed(boolean bed) {
        this.bed = bed;
    }

    public boolean isWashingMachine() {
        return washingMachine;
    }

    public void setWashingMachine(boolean washingMachine) {
        this.washingMachine = washingMachine;
    }

    public boolean isRefrigerator() {
        return refrigerator;
    }

    public void setRefrigerator(boolean refrigerator) {
        this.refrigerator = refrigerator;
    }

    public boolean isAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(boolean airConditioner) {
        this.airConditioner = airConditioner;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isSofa() {
        return sofa;
    }

    public void setSofa(boolean sofa) {
        this.sofa = sofa;
    }

    public boolean isTableChair() {
        return tableChair;
    }

    public void setTableChair(boolean tableChair) {
        this.tableChair = tableChair;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isWaterHeater() {
        return waterHeater;
    }

    public void setWaterHeater(boolean waterHeater) {
        this.waterHeater = waterHeater;
    }

    public boolean isCook() {
        return cook;
    }

    public void setCook(boolean cook) {
        this.cook = cook;
    }

    public boolean isHeating() {
        return heating;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisherNumber() {
        return publisherNumber;
    }

    public void setPublisherNumber(String publisherNumber) {
        this.publisherNumber = publisherNumber;
    }

    public List<HouseTag> getTagList() {
        return tagList;
    }

    public void setTagList(List<HouseTag> tagList) {
        this.tagList = tagList;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherType() {
        return publisherType;
    }

    public void setPublisherType(String publisherType) {
        this.publisherType = publisherType;
    }

    public String getPublisherHead() {
        return publisherHead;
    }

    public void setPublisherHead(String publisherHead) {
        this.publisherHead = publisherHead;
    }

}
