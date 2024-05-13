package com.zoe.starfish_server.common.resp;

import com.zoe.starfish_server.domain.HouseTag;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 房源列表返回的数据
 */
@Data
@NoArgsConstructor
@ToString
public class HouseResourceResp {
    //房源id
    private Long id;

    //缩略图
    private String image;

    //标题
    private String title;

    //子标题
    private String subTitle;
    //租金/元
    private Long rent;
    //标签
    private List<HouseTag> tagList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Long getRent() {
        return rent;
    }

    public void setRent(Long rent) {
        this.rent = rent;
    }

    public List<HouseTag> getTagList() {
        return tagList;
    }

    public void setTagList(List<HouseTag> tagList) {
        this.tagList = tagList;
    }
}
