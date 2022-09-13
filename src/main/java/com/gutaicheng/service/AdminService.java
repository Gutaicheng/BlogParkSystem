package com.gutaicheng.service;

import com.gutaicheng.model.Admin;

import javax.servlet.http.HttpSession;

public interface AdminService {
    public String loginPage();
    public Admin login(Admin admin, HttpSession session);
    public String toIndex();
    public String userInfo();
    String userArticle();
    String pendingArticle();
    String pendingDownload();
    String pendingResult();
    String articleTags();
    String userColumn();
}
