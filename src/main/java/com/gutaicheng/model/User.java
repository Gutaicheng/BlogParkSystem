package com.gutaicheng.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class User {
    /**
     * uid              用户id
     * username         用户名
     * password         用户密码
     * tel              用户电话
     * email            用户邮箱
     * headshot         用户头像
     * registerTime     用户注册时间
     * introduction     用户介绍
     */
    Integer uid;
//    @NotEmpty(message = "{用户名必填}")
    String username;
//    @Length(min = 6, max = 20, message = "{密码长度无效}")
    String password;
    String tel;
    String email;
//    @Past(message = "{日期不能为系统日期之后}")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    Date registeredTime;
    String introduction;
    Integer status;
    String headshot;
    MultipartFile headshotFile;

    public User() {
    }

    public User(Integer uid, String username, String password, String tel, String email, Date registeredTime, String introduction, Integer status, String headshot, MultipartFile headshotFile) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.tel = tel;
        this.email = email;
        this.registeredTime = registeredTime;
        this.introduction = introduction;
        this.status = status;
        this.headshot = headshot;
        this.headshotFile = headshotFile;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(Date registeredTime) {
        this.registeredTime = registeredTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    public MultipartFile getHeadshotFile() {
        return headshotFile;
    }

    public void setHeadshotFile(MultipartFile headshotFile) {
        this.headshotFile = headshotFile;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", registeredTime='" + registeredTime + '\'' +
                ", introduction='" + introduction + '\'' +
                ", status=" + status +
                ", headshot='" + headshot + '\'' +
                '}';
    }
}
