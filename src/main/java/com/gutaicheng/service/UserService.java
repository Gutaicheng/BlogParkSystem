package com.gutaicheng.service;

import com.gutaicheng.model.User;
import com.gutaicheng.model.UserArticles;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    String homepage();
    String userLoginPage();
    String userWrite();
    String download();
    String personalCenter();
    String publishDownload();
    String userInfo();
    String userInfoEdit();
    String blogsControl();
    String downloadControl();
    String columnControl();
    String userCenter(String uid);
    String updateArticle();
    List<UserArticles> selectAllArticleByUid(int uid);
    List<User> selectAllUser();
    void deleteUserByUid(int uid);
    User selectUserByUid(int uid);
    User selectUserByUsername(String username);
    int editUserInfo(User user);
    int enableOrDisableUser(User user);
    int addUser(User user);
//    String listAllByPage(Model model, Integer pageCur);
    User userLogin(User user, HttpSession session);
    void userSignOut(HttpSession session);
    void updateUserHeadshotByUid(int uid, String headshot);
    void updateUserInfoByUser(User user);
}
