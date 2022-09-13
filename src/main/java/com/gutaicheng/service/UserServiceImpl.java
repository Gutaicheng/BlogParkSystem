package com.gutaicheng.service;


import com.gutaicheng.dao.UserMapper;
import com.gutaicheng.model.User;
import com.gutaicheng.model.UserArticles;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("UserService")
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    /**
     * 跳转至首页
     */
    @Override
    public String homepage() {
        return "/user/article.html";
    }

    /**
     * 跳转至用户登录
     */
    @Override
    public String userLoginPage() {
        return "/user/userLogin.html";
    }

    /**
     * 跳转至用户创作
     */
    @Override
    public String userWrite() {
        return "/user/write.html";
    }

    /**
     * 跳转资源页面
     */
    @Override
    public String download() {
        return "/user/download.html";
    }

    /**
     * 用户个人中心首页
     */
    @Override
    public String personalCenter() {
        return "/user/personalcenter.html";
    }

    /**
     * 用户个人中心 上传资源页
     */
    @Override
    public String publishDownload() {
        return "/user/publish.html";
    }

    /**
     * 用户个人中心 信息页
     */
    @Override
    public String userInfo() {
        return "/user/userinfo.html";
    }

    /**
     * 用户个人中心 信息编辑页
     */
    @Override
    public String userInfoEdit() {
        return "/user/userinfo-edit.html";
    }

    /**
     * 用户个人中心 博客信息管理页
     */
    @Override
    public String blogsControl() {
        return "/user/user-blog-control.html";
    }

    /**
     * 用户个人中心 资源信息管理页
     */
    @Override
    public String downloadControl() {
        return "/user/user-download-control.html";
    }

    /**
     * 用户个人中心 专栏信息管理页
     */
    @Override
    public String columnControl() {
        return "/user/user-column-control.html";
    }

    /**
     *跳转至用户中心
     */
    @Override
    public String userCenter(String uid) {
        return "/user/usercenter.html";
    }

    /**
     * 用户修改文章页
     */
    @Override
    public String updateArticle() {
        return "/user/update-article.html";
    }

    /**
     * 根据用户uid查询该用户所有文章
     */
    @Override
    public List<UserArticles> selectAllArticleByUid(int uid) {
        List<UserArticles> userArticles = userMapper.selectAllArticleByUid(uid);
        System.out.println(userArticles);
        return userArticles;
    }

    /**
     * 查询所有用户
     */
    @Override
    public List<User> selectAllUser() {
        System.out.println("查询所有用户："+ userMapper.selectAllUser());
        return userMapper.selectAllUser();
    }

    /**、
     * 根据uid删除用户
     * @param uid
     */
    @Override
    public void deleteUserByUid(int uid) {
        userMapper.deleteUserByUid(uid);
        System.out.println("service已执行删除"+uid);
    }

    /**
     * 根据uid查询用户
     */
    @Override
    public User selectUserByUid(int uid) {
        return userMapper.selectUserByUid(uid);
    }

    /**
     * 根据username查询用户
     */
    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    /**
     * 编辑用户信息
     * @param user
     * @return
     */
    @Override
    public int editUserInfo(User user) {
        return userMapper.editUserInfo(user);
    }

    /**
     * 启用或封禁用户
     * @param user
     * @return
     */
    @Override
    public int enableOrDisableUser(User user) {
        return userMapper.enableOrDisableUser(user);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    /**
     * 用户登录
     */
    @Override
    public User userLogin(User user, HttpSession session) {
        User u = userMapper.selectLoginUser(user);
        if (u != null){
            session.setAttribute("user",u);
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
        return u;
    }

    /**
     * 用户注销
     */
    @Override
    public void userSignOut(HttpSession session) {
        session.removeAttribute("user");
        System.out.println("退出成功");
    }

    /**
     * 根据 uid 更新用户头像
     */
    @Override
    public void updateUserHeadshotByUid(int uid, String headshot) {
        userMapper.updateUserHeadshotByUid(uid,headshot);
    }

    /**
     * 用户 修改用户信息
     */
    @Override
    public void updateUserInfoByUser(User user) {
        userMapper.updateUserInfoByUser(user);
    }


//    /**
//     * 分页查询所有用户
//     * @param model
//     * @param pageCur
//     * @return
//     */
//    @Override
//    public String listAllByPage(Model model, Integer pageCur) {
//        List<User> allUsers = userMapper.selectAllUser();
//        System.out.println(allUsers);
//        int temp = allUsers.size();
//        model.addAttribute("totalCount",temp);
//        int totalPage = 0;
//        if (temp == 0){
//            totalPage = 0;
//        }else {
//            //获取总页数
//            totalPage = (int)Math.ceil((double)temp/3);
//        }
//        if (pageCur == null){
//            pageCur = 1;
//        }
//        if ((pageCur - 1) * 3 > temp){
//            pageCur = pageCur - 1;
//        }
//        //定义开始页面和每页显示的记录条数
//        Map<String, Object> map = new HashMap<>();
//        map.put("startIndex",(pageCur-1) * 3);
//        map.put("perPageSize",3);
//        allUsers = userMapper.listAllByPage(map);
//        model.addAttribute("allUsers",allUsers);
//        model.addAttribute("totalPage",totalPage);
//        model.addAttribute("PageCur",pageCur);
//        model.addAttribute("PageSize",3);
//
//        return "listuser.jsp";
//    }

}
