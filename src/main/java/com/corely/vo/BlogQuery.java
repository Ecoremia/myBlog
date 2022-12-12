package com.corely.vo;

import com.corely.entity.Type;

import java.util.Date;

public class BlogQuery {
    //blog管理页显示数据
    private Long id;
    private String title;
    private Boolean recommend;
    private Date createTime;
    private Date updateTime;
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BlogQuery{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", recommend=" + recommend +
                ", updateTime=" + updateTime +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
