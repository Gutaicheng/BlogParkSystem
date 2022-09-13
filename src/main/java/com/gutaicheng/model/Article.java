package com.gutaicheng.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class Article {
    private Integer aid;
    private Integer uid;
    private String title;
    private String content;
    private String text;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date data;
    private Integer state;
    private Integer views;
    private Integer comments;
    private String cover;
    MultipartFile coverFile;
    private User belongsUser;

    public Article() {
    }

    public Article(Integer aid, Integer uid, String title, String content, String text, Date data, Integer state, Integer views, Integer comments, String cover, MultipartFile coverFile, User belongsUser) {
        this.aid = aid;
        this.uid = uid;
        this.title = title;
        this.content = content;
        this.text = text;
        this.data = data;
        this.state = state;
        this.views = views;
        this.comments = comments;
        this.cover = cover;
        this.coverFile = coverFile;
        this.belongsUser = belongsUser;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public MultipartFile getCoverFile() {
        return coverFile;
    }

    public void setCoverFile(MultipartFile coverFile) {
        this.coverFile = coverFile;
    }

    public User getBelongsUser() {
        return belongsUser;
    }

    public void setBelongsUser(User belongsUser) {
        this.belongsUser = belongsUser;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aid=" + aid +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", text='" + text + '\'' +
                ", data=" + data +
                ", state=" + state +
                ", views=" + views +
                ", comments=" + comments +
                ", cover='" + cover + '\'' +
                ", coverFile=" + coverFile +
                '}';
    }

    public String ArticleAndUser(){
        return "Article{" +
                "aid=" + aid +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", data='" + data + '\'' +
                ", views=" + views +
                ", belongsUserId=" + belongsUser.uid +
                ", belongsUserName='" + belongsUser.username + '\'' +
                ", belongsUserIntroduction='" + belongsUser.introduction + '\'' +
                '}';
    }
}
