package com.xx.mybatis.generator.domain;

import java.io.Serializable;
import java.util.Date;

/**
* 活动表
*/
public class ActivityDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 
    */
    private Long id;

    /**
    * 活动ID
    */
    private Long activityId;

    /**
    * 活动名称
    */
    private String activityName;

    /**
    * 活动类型
    */
    private Integer activityType;

    /**
    * 活动状态
    */
    private Integer activityStatus;

    /**
    * 是否删除 1：删除 0：未删除
    */
    private Integer isDelete;

    /**
    * 活动标签
    */
    private String tag;

    /**
    * 创建时间
    */
    private Date gmtCreate;

    /**
    * 修改时间
    */
    private Date gmtModified;

    /**
    * 是否定向媒体 0不定向 1定向
    */
    private Integer isDirectMedia;

    /**
    * 是否定向广告券 0未定向1定向
    */
    private Integer isDirectAdvert;

    /**
    * 0仅投放定制广告列表，1优先投放定制广告券列表
    */
    private Integer directAdvertMode;

    /**
    * 是否发布 0未发布，1已发布
    */
    private Integer isPublish;

    /**
    * 活动是否开启 0不开启1开启
    */
    private Integer isEnable;

    /**
    * 活动关联规格ID列表
    */
    private String activityMsList;

    /**
    * 是否为新活动 1：新活动；0：旧活动（曝光量<2000定义为新活动）
    */
    private Integer isNewAct;

    /**
    * 活动来源 0-兑吧活动 1-推啊活动 2-流量引导页 20 游戏 21 游戏大厅
    */
    private Integer source;

    /**
    * 推广计划描述
    */
    private String description;

    /**
    * 推广计划标题
    */
    private String planTitle;

    /**
    * 活动皮肤类型
    */
    private String subType;

    /**
    * 周期活动的时间表达式
    */
    private String cronExpression;

    /**
    * 周期活动的时间类型，0非周期投放，1按星期，2按月
    */
    private Integer cronType;

    /**
    * 是否是海外活动 0正常  1海外
    */
    private Integer overseas;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setIsDirectMedia(Integer isDirectMedia) {
        this.isDirectMedia = isDirectMedia;
    }

    public Integer getIsDirectMedia() {
        return isDirectMedia;
    }

    public void setIsDirectAdvert(Integer isDirectAdvert) {
        this.isDirectAdvert = isDirectAdvert;
    }

    public Integer getIsDirectAdvert() {
        return isDirectAdvert;
    }

    public void setDirectAdvertMode(Integer directAdvertMode) {
        this.directAdvertMode = directAdvertMode;
    }

    public Integer getDirectAdvertMode() {
        return directAdvertMode;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    public Integer getIsPublish() {
        return isPublish;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setActivityMsList(String activityMsList) {
        this.activityMsList = activityMsList;
    }

    public String getActivityMsList() {
        return activityMsList;
    }

    public void setIsNewAct(Integer isNewAct) {
        this.isNewAct = isNewAct;
    }

    public Integer getIsNewAct() {
        return isNewAct;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getSource() {
        return source;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    public String getPlanTitle() {
        return planTitle;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getSubType() {
        return subType;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronType(Integer cronType) {
        this.cronType = cronType;
    }

    public Integer getCronType() {
        return cronType;
    }

    public void setOverseas(Integer overseas) {
        this.overseas = overseas;
    }

    public Integer getOverseas() {
        return overseas;
    }

}

