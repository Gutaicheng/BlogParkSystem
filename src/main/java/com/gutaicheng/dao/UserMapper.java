package com.gutaicheng.dao;

import com.gutaicheng.model.User;
import com.gutaicheng.model.UserArticles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("userMapper")
public interface UserMapper {
    public List<UserArticles> selectAllArticleByUid(int uid);
    public List<User> selectAllUser();
    public void deleteUserByUid(int uid);
    public User selectUserByUid(int uid);
    public int editUserInfo(User user);
    public int enableOrDisableUser(User user);
    public int addUser(User user);
    public List<User> listAllByPage(Map<String,Object> map);
    public User selectLoginUser(User user);
    public void updateUserHeadshotByUid(@Param("uid") int uid, @Param("headshot") String headshot);
    User selectUserByUsername(String username);

    void updateUserInfoByUser(User user);
}
