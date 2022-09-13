package com.gutaicheng.controller;

import com.gutaicheng.model.Admin;
import com.gutaicheng.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 登录界面
     * @return
     */
    @RequestMapping("/loginPage")
    public String loginPage(){
        return adminService.loginPage();
    }

    /**
     * 登录验证
     */
    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    @ResponseBody
    public Admin adminLogin(@ModelAttribute Admin admin, HttpSession session, HttpServletResponse response){
        System.out.println(adminService.login(admin, session));
        return adminService.login(admin, session);
    }

    /**
     * 后台首页
     */
    @RequestMapping("/index")
    public String toIndex(){
        return adminService.toIndex();
    }

    /**
     * 用户信息管理页
     */
    @RequestMapping("/userInfo")
    public String userInfo(){
        return adminService.userInfo();
    }

    /**
     * 用户文章管理页
     */
    @RequestMapping("/userArticle")
    public String userArticle(){
        return adminService.userArticle();
    }

    /**
     * 待审文章页
     */
    @RequestMapping("/pendingArticle")
    public String pendingArticle(){
        return adminService.pendingArticle();
    }

    /**
     * 待审 资源页
     */
    @RequestMapping("/pendingDownload")
    public String pendingDownload(){
        return adminService.pendingDownload();
    }


    /**
     * 审核记录页
     */
    @RequestMapping("/pendingResult")
    public String pendingResult(){
        return adminService.pendingResult();
    }

    /**
     * 文章标签管理页
     */
    @RequestMapping("/articleTags")
    public String articleTags(){
        return adminService.articleTags();
    }

    /**
     * 用户专栏管理
     */
    @RequestMapping("/userColumn")
    public String userColumn(){
        return adminService.userColumn();
    }
}