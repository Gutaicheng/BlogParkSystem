package com.gutaicheng.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Pending {
    Integer pid;
    Integer uid;
    String username;
    String ptitle;
    Integer type;
    Integer paid;
    String adminname;
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    Date pdate;
    Integer presult;

    public Pending() {
    }

    public Pending(Integer pid, Integer uid, String username, String ptitle, Integer type, Integer paid, String adminname, Date pdate, Integer presult) {
        this.pid = pid;
        this.uid = uid;
        this.username = username;
        this.ptitle = ptitle;
        this.type = type;
        this.paid = paid;
        this.adminname = adminname;
        this.pdate = pdate;
        this.presult = presult;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Integer getPresult() {
        return presult;
    }

    public void setPresult(Integer presult) {
        this.presult = presult;
    }

    @Override
    public String toString() {
        return "Pending{" +
                "pid=" + pid +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", ptitle='" + ptitle + '\'' +
                ", type=" + type +
                ", paid=" + paid +
                ", adminname='" + adminname + '\'' +
                ", pdate=" + pdate +
                ", presult=" + presult +
                '}';
    }
}
