package com.gutaicheng.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Download {
    //资源id
    Integer did;
    //资源名
    String dname;
    //上传者id
    Integer uid;
    //上传时间
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    Date loadtime;
    //资源描述
    String dmiaoshu;
    //资源路径
    String dfile;
    //资源格式
    String dformat;
    //上传者用户名
    String dusername;
    //状态
    Integer state;
    //下载次数
    Integer downloadtime;
    public Download() {
    }

    public Download(Integer did, String dname, Integer uid, Date loadtime, String dmiaoshu, String dfile, String dformat, String dusername, Integer state, Integer downloadtime) {
        this.did = did;
        this.dname = dname;
        this.uid = uid;
        this.loadtime = loadtime;
        this.dmiaoshu = dmiaoshu;
        this.dfile = dfile;
        this.dformat = dformat;
        this.dusername = dusername;
        this.state = state;
        this.downloadtime = downloadtime;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getLoadtime() {
        return loadtime;
    }

    public void setLoadtime(Date loadtime) {
        this.loadtime = loadtime;
    }

    public String getDmiaoshu() {
        return dmiaoshu;
    }

    public void setDmiaoshu(String dmiaoshu) {
        this.dmiaoshu = dmiaoshu;
    }

    public String getDfile() {
        return dfile;
    }

    public void setDfile(String dfile) {
        this.dfile = dfile;
    }

    public String getDformat() {
        return dformat;
    }

    public void setDformat(String dformat) {
        this.dformat = dformat;
    }

    public String getDusername() {
        return dusername;
    }

    public void setDusername(String dusername) {
        this.dusername = dusername;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDownloadtime() {
        return downloadtime;
    }

    public void setDownloadtime(Integer downloadtime) {
        this.downloadtime = downloadtime;
    }

    @Override
    public String toString() {
        return "Download{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", uid=" + uid +
                ", loadtime=" + loadtime +
                ", dmiaoshu='" + dmiaoshu + '\'' +
                ", dfile='" + dfile + '\'' +
                ", dformat='" + dformat + '\'' +
                ", dusername='" + dusername + '\'' +
                ", state=" + state +
                ", downloadtime=" + downloadtime +
                '}';
    }
}
