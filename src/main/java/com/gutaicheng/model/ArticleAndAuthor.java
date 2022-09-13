package com.gutaicheng.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ArticleAndAuthor {
    private Integer aid;
    private Integer uid;
    private String title;
    private String text;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date data;
    private Integer state;
    private Integer views;
    private Integer comments;
    private String cover;
    private String username;

    public ArticleAndAuthor() {
    }

    public ArticleAndAuthor(Integer aid, Integer uid, String title, String text, Date data, Integer state, Integer views, Integer comments, String cover, String username) {
        this.aid = aid;
        this.uid = uid;
        this.title = title;
        this.text = text;
        this.data = data;
        this.state = state;
        this.views = views;
        this.comments = comments;
        this.cover = cover;
        this.username = username;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "ArticleAndAuthor{" +
                "aid=" + aid +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", data=" + data +
                ", state=" + state +
                ", views=" + views +
                ", comments=" + comments +
                ", cover='" + cover + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
