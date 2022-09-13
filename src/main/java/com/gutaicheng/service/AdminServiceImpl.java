package com.gutaicheng.service;

import com.gutaicheng.dao.AdminMapper;
import com.gutaicheng.model.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service("AdminService")
public class AdminServiceImpl implements AdminService{
    @Resource
    public AdminMapper adminMapper;

    /**
     * 跳转至 管理员登录 页面
     * @return
     */
    @Override
    public String loginPage() {
        return "/admin/login.html";
    }

    /**
     * 管理员登录验证
     */
    @Override
    public Admin login(Admin admin, HttpSession session) {
//        if (adminMapper.selectByUsername(admin.getUsername(),admin.getPassword()) != null){
//            Admin user = adminMapper.selectByUsername(admin.getUsername(),admin.getPassword());
//            System.out.println("登录成功！用户名："+user);
//            return "redirect:/admin/index.html";
//        }
//        System.out.println("登陆失败");
//        return "/admin/login.html";
        return adminMapper.selectByUsername(admin.getUsername(),admin.getPassword());
    }

    /**
     * 跳转至管理员后台首页
     */
    @Override
    public String toIndex() {
        return "/admin/index.html";
    }

    /**
     * 跳转至用户信息界面
     * @return
     */
    @Override
    public String userInfo() {
        return "user-info.html";
    }

    /**
     * 用户文章页
     */
    @Override
    public String userArticle() {
        return "user-article.html";
    }

    /**
     * 待审文章页
     */
    @Override
    public String pendingArticle() {
        return "pending-article.html";
    }

    /**
     * 待审 资源页
     */
    @Override
    public String pendingDownload() {
        return "pending-download.html";
    }

    /**
     * 审核记录页
     */
    @Override
    public String pendingResult() {
        return "pending-result.html";
    }

    /**
     * 文章标签管理页
     */
    @Override
    public String articleTags() {
        return "article-tag.html";
    }

    /**
     * 用户专栏管理页
     */
    @Override
    public String userColumn() {
        return "user-column.html";
    }

}
