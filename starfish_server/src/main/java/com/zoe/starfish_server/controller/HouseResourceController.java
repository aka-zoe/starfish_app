package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.ConstantsField;
import com.zoe.starfish_server.common.RespCodeEnum;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.common.resp.HouseResourceDetailResp;
import com.zoe.starfish_server.common.resp.HouseResourceResp;
import com.zoe.starfish_server.domain.*;
import com.zoe.starfish_server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 房源控制器
 */
@RestController
@RequestMapping("/houseResource")
public class HouseResourceController {
    //房源服务
    @Autowired
    HouseResourceService service;

    //小区服务
    @Autowired
    LivingAreaService areaService;

    //图片服务
    @Autowired
    HouseImgService imgService;

    //标签服务
    @Autowired
    HouseTagService tagService;

    //户型服务
    @Autowired
    HouseTypeService typeService;

    @GetMapping("/allHouseResources")
    public CommonResp allHouseResources() {
        //获取所有房源
        List<HouseResource> houseResources = service.houseResources(true);
        return CommonResp.success(generResList(houseResources));
    }

    @GetMapping("/houseResources")
    public CommonResp houseResources() {
        //获取所有房源:筛选正常状态的房源列表
        List<HouseResource> houseResources = service.houseResources(false);
        return CommonResp.success(generResList(houseResources));
    }

    @GetMapping("/houseResourceDetail")
    public CommonResp houseResourceDetail(@RequestParam(value = "id", required = true) Long id) {
        HouseResource resource = service.houseResourceDetail(id);
        if (resource == null) {
            return CommonResp.error(RespCodeEnum.EMPTYDATA);
        }
        HouseResourceDetailResp resp = generalDetail(resource);
        return CommonResp.success(resp);
    }

    @PostMapping("/insertHouseResource")
    public CommonResp insertHouseResource(@RequestBody HouseResource houseResource) {
        int code = service.insertHouseResource(houseResource);
        if (code == -1) {
            return CommonResp.error(RespCodeEnum.ALREADYEXIST);
        }
        return CommonResp.success(code);
    }

    @DeleteMapping("/deleteHouseResource")
    public CommonResp deleteHouseResource(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.success(service.deleteHouseResource(id));
    }

    @PostMapping("/updateHouseResource")
    public CommonResp updateHouseResource(@RequestBody HouseResource houseResource) {
        return CommonResp.success(service.updateHouseResource(houseResource));
    }

    private HouseResourceDetailResp generalDetail(HouseResource resource) {
        HouseResourceDetailResp resp = new HouseResourceDetailResp();

        //房源图片
        resp.setImageList(getImgList(imgService.imgForHouse(resource.getId())));
        //说明
        resp.setHouseDesc(resource.getHouseDesc());
        //租赁类型
        resp.setLeaseType(resource.getLeaseType());
        //租金
        resp.setRent(resource.getRent());
        //中介费
        resp.setServiceCharge(resource.getServiceCharge());
        //户型名称
        HouseType type = typeService.getType(resource.getHouseTypeId());
        if (type != null) {
            resp.setHouseTypeName(type.getFullName());
        } else {
            resp.setHouseTypeName("");
        }
        //房源类型
        resp.setHouseType(resource.getHouseType());
        //朝向
        resp.setDirection(resource.getDirection());
        //可入住时间
        resp.setCheckInDate(resource.getCheckInDate());
        //总楼层
        resp.setTotalFloor(resource.getTotalFloor());
        //当前楼层
        resp.setCurrentFloor(resource.getCurrentFloor());
        //小区名称
        LivingArea area = areaService.getArea(resource.getHouseAreaId());
        if (area != null) {
            resp.setHouseArea(area.getAreaName());
        } else {
            resp.setHouseArea("");
        }
        //面积
        resp.setAcreage(resource.getAcreage());
        //发布时间
        resp.setPublishDate(resource.getPublishDate());
        //装修类型
        resp.setFitment(resource.getFitment());
        //支付类型
        resp.setPaymentType(resource.getPaymentType());
        //床
        resp.setBed(resource.getBed() == 0);
        //洗衣机
        resp.setWashingMachine(resource.getWashingMachine() == 0);
        //冰箱
        resp.setRefrigerator(resource.getRefrigerator() == 0);
        //空调
        resp.setAirConditioner(resource.getAirConditioner() == 0);
        //wifi
        resp.setWifi(resource.getWifi() == 0);
        //沙发
        resp.setSofa(resource.getSofa() == 0);
        //桌椅
        resp.setTableChair(resource.getTableChair() == 0);
        //电视
        resp.setTv(resource.getTv() == 0);
        //热水器
        resp.setWaterHeater(resource.getWaterHeater() == 0);
        //可做饭
        resp.setCook(resource.getCook() == 0);
        //暖气
        resp.setHeating(resource.getHeating() == 0);
        //阳台
        resp.setBalcony(resource.getBalcony() == 0);
        //经度
        resp.setLongitude(resource.getLongitude());
        //纬度
        resp.setLatitude(resource.getLatitude());
        //发布人
        resp.setPublisher(resource.getPublisher());
        //发布人电话
        resp.setPublisherNumber(resource.getPublisherNumber());
        //标签列表
        List<HouseTag> houseTags = tagService.tagListForHouse(resource.getId());
        resp.setTagList(houseTags);
        //发布人id
        resp.setPublisherId(resource.getPublisherId());
        //发布人类型
        resp.setPublisherType(resource.getPublisherType());
        //发布人头像
        resp.setPublisherHead(resource.getPublisherHead());
        return resp;
    }

    private List<String> getImgList(List<HouseImg> houseImgs) {
        if (houseImgs == null || houseImgs.isEmpty()) {
            return new ArrayList<String>();
        }
        List<String> imageList = new ArrayList<>();
        for (HouseImg img : houseImgs) {
            imageList.add(img.getImageUrl());
        }
        return imageList;
    }

    /**
     * 生成房源列表
     *
     * @param houseResources
     * @return
     */
    private List<HouseResourceResp> generResList(List<HouseResource> houseResources) {
        List<HouseResourceResp> resList = new ArrayList<>();
        if (houseResources != null && !houseResources.isEmpty()) {
            //遍历
            for (HouseResource resource : houseResources) {
                HouseResourceResp resp = new HouseResourceResp();
                //房租支付方式
                Integer paymentType = resource.getPaymentType();
                String payType = "";
                switch (paymentType) {
                    case 0:
                        payType = ConstantsField.paymentType0;
                        break;
                    case 1:
                        payType = ConstantsField.paymentType1;
                        break;
                    case 2:
                        payType = ConstantsField.paymentType2;
                        break;
                    case 3:
                        payType = ConstantsField.paymentType3;
                        break;
                    default:

                }
                //小区名称
                LivingArea area = areaService.getArea(resource.getId());
                if (area != null) {
                    String areaName = area.getAreaName();
                    //标题
                    resp.setTitle(areaName + payType);
                } else {
                    //标题
                    resp.setTitle(payType);
                }

                //户型
                HouseType type = typeService.getType(resource.getHouseTypeId());
                if (type != null) {
                    String typeName = type.getTypeName();
                    //二级标题
                    resp.setSubTitle(resource.getHouseDesc() + typeName);
                } else {
                    //二级标题
                    resp.setSubTitle(resource.getHouseDesc());
                }

                //标签列表
                List<HouseTag> houseTags = tagService.tagListForHouse(resource.getId());
                resp.setTagList(houseTags);

                //缩略图
                resp.setImage(resource.getImage());
                //租金
                resp.setRent(resource.getRent());
                //房源id
                resp.setId(resource.getId());
                resList.add(resp);
            }
        }
        return resList;
    }
}
