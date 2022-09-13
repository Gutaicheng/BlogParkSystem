package com.gutaicheng.model;

public class UserArticles {
    Integer uid;
    Integer aid;
    String title;
    String text;
    String data;
    Integer views;

    public UserArticles(Integer uid, Integer aid, String title, String text, String data, Integer views) {
        this.uid = uid;
        this.aid = aid;
        this.title = title;
        this.text = text;
        this.data = data;
        this.views = views;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "UserArticles{" +
                "uid=" + uid +
                ", aid=" + aid +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", data='" + data + '\'' +
                ", views=" + views +
                '}';
    }
}
