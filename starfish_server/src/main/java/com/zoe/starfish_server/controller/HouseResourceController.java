package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.ConstantsField;
import com.zoe.starfish_server.common.resp.CommonResp;
import com.zoe.starfish_server.common.resp.HouseResourceResp;
import com.zoe.starfish_server.domain.HouseResource;
import com.zoe.starfish_server.domain.HouseTag;
import com.zoe.starfish_server.domain.HouseType;
import com.zoe.starfish_server.domain.LivingArea;
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

    @GetMapping("/houseResources")
    public CommonResp houseResources() {
        List<HouseResourceResp> resList = new ArrayList<>();
        //获取所有房源
        List<HouseResource> houseResources = service.houseResources();
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
        return CommonResp.successRsp(resList);
    }

    @GetMapping("/houseResourceDetail")
    public CommonResp houseResourceDetail(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.successRsp(service.houseResourceDetail(id));
    }

    @PostMapping("/insertHouseResource")
    public CommonResp insertHouseResource(@RequestBody HouseResource houseResource) {
        int code = service.insertHouseResource(houseResource);
        if (code == -1) {
            return CommonResp.errorRsp("数据已存在", code);
        }
        return CommonResp.successRsp(code);
    }

    @DeleteMapping("/deleteHouseResource")
    public CommonResp deleteHouseResource(@RequestParam(value = "id", required = true) Long id) {
        return CommonResp.successRsp(service.deleteHouseResource(id));
    }

    @PostMapping("/updateHouseResource")
    public CommonResp updateHouseResource(@RequestBody HouseResource houseResource) {
        return CommonResp.successRsp(service.updateHouseResource(houseResource));
    }
}
