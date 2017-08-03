package com.bignerdranch.android.enterpriseshow.bean;

/**
 * Created by Administrator on 2017/8/2/002.
 */

public class Statistics {
    private static final long serialVersionUID = -6124796705690819198L;
    Long siteId; //站点ID
    String siteTitle; //站点名称
    String siteLogo; //站点logo
    Integer pageviews; //浏览量
    Integer visitNumber; // 访问人数
    Integer forwardNumber; //转发次数
    Integer newsNumber; //消息
    Integer todayPageviews; //消息
    String createTime; //创建时间
    Integer isEnable; //是否启用，0未启用，1启用
    Integer siteNumber;//站点数量
    Integer type;//0：新增1其他

    public Statistics(Integer type) {
        this.type = type;
    }

    public Statistics() {
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "createTime='" + createTime + '\'' +
                ", siteId=" + siteId +
                ", siteTitle='" + siteTitle + '\'' +
                ", siteLogo='" + siteLogo + '\'' +
                ", pageviews=" + pageviews +
                ", visitNumber=" + visitNumber +
                ", forwardNumber=" + forwardNumber +
                ", newsNumber=" + newsNumber +
                ", todayPageviews=" + todayPageviews +
                ", isEnable=" + isEnable +
                ", siteNumber=" + siteNumber +
                '}';
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSiteNumber() {
        return siteNumber;
    }

    public void setSiteNumber(Integer siteNumber) {
        this.siteNumber = siteNumber;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getTodayPageviews() {
        return todayPageviews;
    }

    public void setTodayPageviews(Integer todayPageviews) {
        this.todayPageviews = todayPageviews;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getForwardNumber() {
        return forwardNumber;
    }

    public void setForwardNumber(Integer forwardNumber) {
        this.forwardNumber = forwardNumber;
    }

    public Integer getNewsNumber() {
        return newsNumber;
    }

    public void setNewsNumber(Integer newsNumber) {
        this.newsNumber = newsNumber;
    }

    public Integer getPageviews() {
        return pageviews;
    }

    public void setPageviews(Integer pageviews) {
        this.pageviews = pageviews;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getSiteLogo() {
        return siteLogo == null ? "" : siteLogo;
    }

    public void setSiteLogo(String siteLogo) {
        this.siteLogo = siteLogo;
    }

    public String getSiteTitle() {
        return siteTitle;
    }

    public void setSiteTitle(String siteTitle) {
        this.siteTitle = siteTitle;
    }

    public Integer getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber(Integer visitNumber) {
        this.visitNumber = visitNumber;
    }

    public int getItemType() {
        return type;
    }
}
