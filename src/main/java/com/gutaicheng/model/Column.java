package com.gutaicheng.model;

public class Column {
    Integer cid;
    Integer uid;
    String cname;
    String username;
    Integer amount;
    public Column() {
    }

    public Column(Integer cid, Integer uid, String cname, String username, Integer amount) {
        this.cid = cid;
        this.uid = uid;
        this.cname = cname;
        this.username = username;
        this.amount = amount;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Column{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", cname='" + cname + '\'' +
                ", username='" + username + '\'' +
                ", amount=" + amount +
                '}';
    }
}
