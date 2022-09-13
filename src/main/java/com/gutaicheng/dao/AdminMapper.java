package com.gutaicheng.dao;

import com.gutaicheng.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("adminMapper")
public interface AdminMapper {
    //根据用户名密码查询
    Admin selectByUsername(@Param("username") String username, @Param("password") String password);
}
