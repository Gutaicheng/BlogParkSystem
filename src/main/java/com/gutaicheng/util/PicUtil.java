package com.gutaicheng.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class PicUtil {
    public static String upload(HttpServletRequest request, MultipartFile userHeadshot) throws IOException {
        String pic = null;//装配后图片的地址
        //上传图片
        if (userHeadshot != null && !userHeadshot.isEmpty()){
            //使用UUID为图片命名
            String name = UUID.randomUUID().toString().replaceAll("-","");
            //获取文件的拓展名
            String ext = FilenameUtils.getExtension(userHeadshot.getOriginalFilename());
            //设置上传路径
            String url = request.getSession().getServletContext().getRealPath("/upload");
            //检验文件夹是否存在
            isFolderExists(url);
            //绝对路径保存
            userHeadshot.transferTo(new File(url + "/" + name + "." + ext));
            //装配图片地址
            pic = "upload/"+name+"."+ext;
        }
        return pic;
    }

    public static String uploadArticle(HttpServletRequest request, MultipartFile ArticlePic) throws IOException {
        String pic = null;//装配后图片的地址
        //上传图片
        if (ArticlePic != null && !ArticlePic.isEmpty()){
            //使用UUID为图片命名
            String name = UUID.randomUUID().toString().replaceAll("-","");
            //获取文件的拓展名
            String ext = FilenameUtils.getExtension(ArticlePic.getOriginalFilename());
            //设置上传路径
            String url = request.getSession().getServletContext().getRealPath("/upload/article");
            //检验文件夹是否存在
            isFolderExists(url);
            //绝对路径保存
            ArticlePic.transferTo(new File(url + "/" + name + "." + ext));

            //装配图片地址
            pic = "upload/article/"+name+"."+ext;
        }
        return pic;
    }

    /**
     * 验证文件夹是否存在
     * @param strFolder
     * @return
     */
    public static boolean isFolderExists(String strFolder){
        File file = new File(strFolder);
        if (!file.exists()) {
            return file.mkdir();
        }
        System.out.println("-----------------文件上传路径："+strFolder);
        return true;
    }


}
