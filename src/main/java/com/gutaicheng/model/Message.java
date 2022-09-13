package com.gutaicheng.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Message {
    Integer mid;
    Integer uid;
    Integer aid;
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    Date messagetime;
    String content;
    String username;
    String headshot;

    public Message() {
    }

    public Message(Integer mid, Integer uid, Integer aid, Date messagetime, String content, String username, String headshot) {
        this.mid = mid;
        this.uid = uid;
        this.aid = aid;
        this.messagetime = messagetime;
        this.content = content;
        this.username = username;
        this.headshot = headshot;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getMessagetime() {
        return messagetime;
    }

    public void setMessagetime(Date messagetime) {
        this.messagetime = messagetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    @Override
    public String toString() {
        return "Message{" +
                "mid=" + mid +
                ", uid=" + uid +
                ", aid=" + aid +
                ", messagetime=" + messagetime +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", headshot='" + headshot + '\'' +
                '}';
    }
}
