package com.udriving.drivingapi.entity.activity;


import com.udriving.drivingapi.util.JacksonUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
public class Activity extends BaseActivity implements ActivitiStatusConstant {
    /**
     * 创建人用户id
     */
    @Column
    private String createUserId;
    /**
     * 活动介绍
     */
    @Column
    private String introduce;
    /**
     * 出发地信息
     */
    @Column
    private String departAddressInfo;
    /**
     * 成员列表
     */
    @Column
    private String memberIdList;
    /**
     * 目的地信息
     */
    @Column
    private String destinationAddressInfo;
    /**
     * 评论id列表
     */
    @Column
    private String commentIdList;
    /**
     * 途径地坐标
     */
    @Column
    private String approachCoordinate;
    /**
     * 活动介绍图片
     */
    @Column
    private String introducePicture;
    /**
     * 活动相册
     */
    @Column
    private String photoAlbum;
    /**
     * 出发时间
     */
    @Column
    private long departTimestamp;
    /**
     * 返回时间
     */
    @Column
    private long backTimestamp;
    /**
     * 创建时间
     */
    @Column
    private long createTimestamp;
    /**
     * 修改时间
     */
    @Column
    private long modifyTimestamp;
    /**
     * 修改人用户id
     */
    @Column
    private String modifyUserId;
    /**
     * 微信群聊二维码
     */
    @Column
    private String weChatFlockQrCode;
    /**
     * 活动状态
     * 创建、审核通过、审核未通过
     */
    @Column
    private int status;
    /**
     * 参加活动的车辆号
     */
    @Column
    private String carNumber;
    /**
     * 路线图片
     */
    @Column
    private String pathImage;
    /**
     * 查看次数
     */
    @Column
    private long lookOverNumber;
    /**
     * 注意事项
     */
    @Column
    private String notes;
    /**
     * 审批意见
     */
    @Column
    private String approveOpinion;

    /**
     * 获取活动介绍图片
     *
     * @return 活动介绍图片
     */
    public List<String> getIntroducePicture() {
        if (introducePicture == null) {
            return null;
        }
        //图片名列表
        List<String> imageNameList = null;
        //图片名列表
        List<String> imageUrlList = new LinkedList<>();
        try {
            imageNameList = JacksonUtil.json2Bean(introducePicture, List.class);
        } catch (IOException e) {
            return null;
        }
        for (String imageName : imageNameList) {
            imageUrlList.add("https://liuhao.space/" + imageName);
        }
        return imageUrlList;
    }

    /**
     * 设置活动介绍图片(数据库框架使用)
     *
     * @param introducePicture 从数据库中读取的活动介绍图片列表
     */
    public void setIntroducePicture(String introducePicture) {
        this.introducePicture = introducePicture;
    }

    /**
     * 设置活动介绍图片
     *
     * @param introducePicture 活动介绍图片链接列表
     */
    public void setIntroducePicture(List<String> introducePicture) {
        if (introducePicture == null) {
            return;
        }
        //图片名列表
        List<String> imageNameList = new LinkedList<>();
        //将客户端传上来的图片链接截取为仅保留图片文件名
        for (String imageUrl : introducePicture) {
            imageNameList.add(imageUrl.substring(imageUrl.lastIndexOf("/") + 1));
        }
        this.introducePicture = JacksonUtil.toJSONString(imageNameList);
    }

    /**
     * 获取目的地信息
     *
     * @return 目的地信息实体
     */
    public AddressInfo getDestinationAddressInfo() {
        if (destinationAddressInfo == null) {
            return null;
        }
        try {
            return JacksonUtil.json2Bean(destinationAddressInfo, AddressInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 设置目的地信息（数据库框架使用）
     *
     * @param destinationAddressInfo 从数据库中读取的目的地信息
     */
    public void setDestinationAddressInfo(String destinationAddressInfo) {
        this.destinationAddressInfo = destinationAddressInfo;
    }

    /**
     * 设置目的地信息
     *
     * @param destinationAddressInfo 目的地信息
     */
    public void setDestinationAddressInfo(AddressInfo destinationAddressInfo) {
        this.destinationAddressInfo = JacksonUtil.toJSONString(destinationAddressInfo);
    }

    /**
     * 获取出发地信息
     *
     * @return 出发地信息实体
     */
    public AddressInfo getDepartAddressInfo() {
        if (departAddressInfo == null) {
            return null;
        }
        try {
            return JacksonUtil.json2Bean(departAddressInfo, AddressInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 设置出发地信息（数据库框架使用）
     *
     * @param departAddressInfo 从数据库中读取的出发地信息实体
     */
    public void setDepartAddressInfo(String departAddressInfo) {
        this.departAddressInfo = departAddressInfo;
    }

    /**
     * 设置出发地信息
     *
     * @param departAddressInfo 出发地信息实体
     */
    public void setDepartAddressInfo(AddressInfo departAddressInfo) {
        this.departAddressInfo = JacksonUtil.toJSONString(departAddressInfo);
    }

    /**
     * 获取活动微信群二维码
     *
     * @return 活动微信群二维码图片链接
     */
    public String getWeChatFlockQrCode() {
        return "https://liuhao.space/" + weChatFlockQrCode;
    }

    /**
     * 设置活动微信群二维码
     *
     * @param weChatFlockQrCode 活动微信群二维码图片链接
     */
    public void setWeChatFlockQrCode(String weChatFlockQrCode) {
        if (StringUtils.isEmpty(weChatFlockQrCode)) {
            return;
        }
        this.weChatFlockQrCode = weChatFlockQrCode.substring(weChatFlockQrCode.lastIndexOf("/") + 1);
    }

    /**
     * 获取路线图链接
     *
     * @return 路线图链接
     */
    public String getPathImage() {
        return "https://liuhao.space/" + pathImage;
    }

    /**
     * 设置路线图链接
     *
     * @param pathImage 路线图链接
     */
    public void setPathImage(String pathImage) {
        this.pathImage = pathImage.substring(pathImage.lastIndexOf("/") + 1);
    }

    /**
     * 获取参加活动的车辆号列表
     *
     * @return 参加活动的车辆号列表
     */
    public List<String> getCarNumber() {
        if (carNumber == null) {
            return null;
        }
        try {
            return JacksonUtil.json2Bean(carNumber, List.class);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 设置参加活动的车辆号
     *
     * @param carNumber 参加活动的车辆号列表
     */
    public void setCarNumber(List<String> carNumber) {
        this.carNumber = JacksonUtil.toJSONString(carNumber);
    }


    /**
     * 获取活动成员列表
     *
     * @return 活动成员id列表
     */
    public List<String> getMemberIdList() {
        if (memberIdList == null) {
            return null;
        }
        try {
            return JacksonUtil.json2Bean(destinationAddressInfo, List.class);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 设置活动成员列表
     *
     * @param memberIdList 活动成员id列表
     */
    public void setMemberIdList(List<String> memberIdList) {
        this.memberIdList = JacksonUtil.toJSONString(memberIdList);
    }

}
