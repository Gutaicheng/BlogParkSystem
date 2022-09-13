package com.gutaicheng.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class Tag extends BaseRowModel {
    @ExcelProperty(value = "id",index = 0)
    Integer tid;
    @ExcelProperty(value = "标签名",index = 1)
    String tagname;

    public Tag() {
    }

    public Tag(Integer tid, String tagname) {
        this.tid = tid;
        this.tagname = tagname;
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
        return "Tag{" +
                "tid=" + tid +
                ", tagname='" + tagname + '\'' +
                '}';
    }
}
