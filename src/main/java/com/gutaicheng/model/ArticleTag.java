package com.gutaicheng.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class ArticleTag extends BaseRowModel {

    Integer aid;

    Integer tid;

    String tagname;

    public ArticleTag() {
    }

    public ArticleTag(Integer aid, Integer tid, String tagname) {
        this.aid = aid;
        this.tid = tid;
        this.tagname = tagname;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    @Override
    public String toString() {
        return "ArticleTag{" +
                "aid=" + aid +
                ", tid=" + tid +
                ", tagname='" + tagname + '\'' +
                '}';
    }
}
