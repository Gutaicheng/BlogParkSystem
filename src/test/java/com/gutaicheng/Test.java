package com.gutaicheng;


import com.gutaicheng.dao.AdminMapper;
import com.gutaicheng.model.Admin;
import com.gutaicheng.service.AdminService;
import com.gutaicheng.service.AdminServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    @org.junit.Test
    public void testSelectAdmin() throws IOException {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取对应的 SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3 获取UserMapper接口的代理对象
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);

        //4.执行对应的接口方法
        Admin admin = adminMapper.selectByUsername("blog","321");
        System.out.println(admin);

        //5.释放资源
        sqlSession.close();
    }

    @org.junit.Test
    public void testService() throws IOException {
        AdminServiceImpl adminService = new AdminServiceImpl();

    }
}
