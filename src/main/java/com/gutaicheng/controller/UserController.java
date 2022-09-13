package com.gutaicheng.controller;

import com.gutaicheng.model.User;
import com.gutaicheng.model.UserArticles;
import com.gutaicheng.service.UserService;
import com.gutaicheng.util.PicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 跳转首页
     */
    @RequestMapping("/homepage")
    public String homepage(){
        return userService.homepage();
    }

    /**
     * 跳转登录
     */
    @RequestMapping("/userLogin")
    public String userLogin(){
        return userService.userLoginPage();
    }

    /**
     * 跳转资源页面
     */
    @RequestMapping("/download")
    public String download(){
        return userService.download();
    }

    /**
     * 创作页面跳转
     */
    @RequestMapping("/write")
    public String userWrite(){
        return userService.userWrite();
    }

    /**
     * 用户个人中心首页
     */
    @RequestMapping("/personalCenter")
    public String personalCenter(){
        return userService.personalCenter();
    }

    /**
     * 用户个人中心 上传资源页
     */
    @RequestMapping("/publishDownload")
    public String publishDownload(){
        return userService.publishDownload();
    }

    /**
     * 用户个人中心 信息页
     */
    @RequestMapping("/userInfo")
    public String userInfo(){
        return userService.userInfo();
    }

    /**
     * 用户个人中心 信息编辑页
     */
    @RequestMapping("/userInfoEdit")
    public String userInfoEdit(){
        return userService.userInfoEdit();
    }

    /**
     * 用户个人中心 博客信息管理页
     */
    @RequestMapping("/blogsControl")
    public String blogsControl(){
        return userService.blogsControl();
    }

    /**
     * 用户个人中心 资源信息管理页
     */
    @RequestMapping("/downloadControl")
    public String downloadControl(){
        return userService.downloadControl();
    }

    /**
     * 用户个人中心 专栏信息管理页
     */
    @RequestMapping("/columnControl")
    public String columnControl(){
        return userService.columnControl();
    }

    /**
     * 用户修改文章页
     */
    @RequestMapping("/updateArticle/{aid}")
    public String updateArticle(){
        return userService.updateArticle();
    }


    /**
     * 访问用户主页
     */
    @RequestMapping("/{username}")
    public String userCenter(@PathVariable(value = "username", required = true) String username){
        return userService.userCenter(username);
    }

    /**
     * 根据 uid 查询该用户的所有文章
     */
    @RequestMapping(value = "/UserArticles")
    @ResponseBody
    public List<UserArticles> UserArticles(int uid) {
        return userService.selectAllArticleByUid(uid);
    }

    /**
     * 查询所有用户
     */
    @RequestMapping(value = "/selectAllUser")
    @ResponseBody
    public List<User> AllUsers() {
        return userService.selectAllUser();
    }

    /**
     * 根据 uid 删除用户
     *
     * @param uid
     */
    @RequestMapping(value = "/deleteUserByUid", method = RequestMethod.POST)
    @ResponseBody
    public void deleteUserByUid(int uid) {
        userService.deleteUserByUid(uid);
        System.out.println("controller已执行删除" + uid);
    }

    /**
     * 根据 uid 查询用户
     */
    @RequestMapping(value = "/selectUserByUid", method = RequestMethod.POST)
    @ResponseBody
    public User selectUserByUid(int uid) {
        System.out.println("根据 uid 查询用户uid="+uid);
        return userService.selectUserByUid(uid);
    }

    /**
     * 根据 username 查询用户
     */
    @RequestMapping(value = "/selectUserByUsername")
    @ResponseBody
    public User selectUserByUid(String username) {
        System.out.println("根据 username 查询用户uid="+username);
        return userService.selectUserByUsername(username);
    }

    /**
     * 接收前端 post 的用户信息（json）进行修改
     *
     * @param user 使用@ModelAttribute注解的实体类接收前端发来的数据格式需要为"x-www-form-urlencoded"，
     * @RequestBody注解的实体类接收前端的数据格式为JSON(application/json)格式。 （若是使用@ModelAttribute接收application/json格式，虽然不会报错，但是值并不会自动填入）
     */
    @RequestMapping(value = "/editUserInfo")
    @ResponseBody
    public void editUserInfo(@RequestBody User user) {
        System.out.println(user);
        System.out.println(userService.editUserInfo(user));
    }

    /**
     * 编辑用户信息
     *
     * @param user
     */
    @RequestMapping(value = "/enableOrDisableUser")
    @ResponseBody
    public void enableOrDisableUser(@RequestBody User user) {
        System.out.println(user);
        if (user.getStatus() == 0) {
            user.setStatus(1);
        } else user.setStatus(0);
        System.out.println(userService.enableOrDisableUser(user));
    }

    /**
     * 管理员添加用户
     *
     * @param user
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public void addUser(@RequestBody User user) {
        System.out.println("管理员添加用户……" + user);
        System.out.println(userService.addUser(user));
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public User userLogin(@RequestBody User user, HttpSession session, HttpServletResponse response) {
        System.out.println(user);
        User u = userService.userLogin(user,session);
        if (u != null){
            Cookie uidCookie = new Cookie("uid",u.getUid().toString());
            Cookie usernameCookie = new Cookie("username",u.getUsername());
            Cookie passwordCookie = new Cookie("password",u.getPassword());
            uidCookie.setMaxAge(60*60*24*7);
            usernameCookie.setMaxAge(60*60*24*7);
            passwordCookie.setMaxAge(60*60*24*7);
            response.addCookie(uidCookie);
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
        }
        return u;
    }

    /**
     * 用户退出登录
     */
    @RequestMapping(value = "/userSignOut")
    @ResponseBody
    public void userSignOut(HttpSession session){
        userService.userSignOut(session);
    }

    /**
     * 用户更改头像
     */
    @RequestMapping(value = "/updateHeadshot", method = RequestMethod.POST)
    @ResponseBody
    public String updateHeadshot(int uid, MultipartFile headshotFile, HttpServletRequest request) throws IOException {
        System.out.println("获取到的uid==>"+uid);
        if (headshotFile != null){
            System.out.println("图片不为空");
            String pic;
            pic = PicUtil.upload(request, headshotFile);
            if (pic != null){
                System.out.println("上传成功");
                return pic;
            }else System.out.println("上传失败");
        }else System.out.println("图片为空");
        return null;
//        userService.updateUserHeadshotByUid(uid,pic);
    }

    /**
     * 用户 修改用户信息
     */
    @RequestMapping(value = "/updateUserInfoByUser", method = RequestMethod.POST)
    @ResponseBody
    public void updateUserInfoByUser(@RequestBody User user){
        userService.updateUserInfoByUser(user);
    }
}


//    /**
//     * 导向addjsp
//     * @param user
//     * @return
//     */
//    @RequestMapping(value = "/add")
//    public String add(@ModelAttribute User user){
//        return "redirect:/admin/tables-datatable.jsp";
////        return "adduser.jsp";
//    }
//
//    @RequestMapping(value = "/addUserByJSP", method = RequestMethod.POST)
//    public String addUserByJSP(@Valid @ModelAttribute User user, BindingResult result){
//        if (result.hasErrors()){
//            System.out.println(result.getAllErrors().toString());
//            return "adduser.jsp";
//        }else {
//            System.out.println("添加用户……"+user);
//            System.out.println(userService.addUser(user));
//            return "redirect:/admin/user-info.html";
//        }
//    }
//
//    /**
//     * 分页显示数据
//     */
//    @RequestMapping(value = "/userlist")
//    public String listAllByPage(Model model, Integer pageCur){
//        return userService.listAllByPage(model,pageCur);
//    }
//}