package com.gutaicheng.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

public class DocUtil {
    public static String upload(HttpServletRequest request, MultipartFile myfile) throws IOException {
        String tpic = null;
        if(myfile !=null && !myfile.isEmpty()){
            String name = UUID.randomUUID().toString().replaceAll("-","");
            String ext = FilenameUtils.getExtension(myfile.getOriginalFilename());
            String url = request.getSession().getServletContext().getRealPath("/upload/download");
            /* isFolderExistis(url);*/
            myfile.transferTo(new File(url + "/" + name + "." + ext));
            tpic = "upload/download/" + name + "." + ext;
        }
        return tpic;
    }

    public static String download(@RequestParam String lfile, HttpServletRequest request, HttpServletResponse response){
        String aFilePath = null;
        FileInputStream in =  null;
        ServletOutputStream out = null;
        try{
            aFilePath = request.getServletContext().getRealPath("");
            response.setHeader("Content-Type","application/x-msdownload");
            response.setHeader("Content-Disposition","attachment; filename =" + toUTF8String(lfile));
            in = new FileInputStream(aFilePath + "\\" + lfile);
            out = response.getOutputStream();
            out.flush();
            int aRead = 0;
            byte b[] = new byte[1024];
            while((aRead = in.read(b)) !=-1 && in !=null){
                out.write(b,0,aRead);
            }
            out.flush();
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("下载成功");
        return null;
    }

    /**
     * 下载保存时中文文件名字符编码转换方法
     */
    public static String toUTF8String(String str){
        StringBuffer sb = new StringBuffer();
        int len = str.length();
        for(int i = 0; i < len; i++){
            //取出字符中的每个字符
            char c = str.charAt(i);
            //Unicode码值在0-255之间，不作处理
            if(c >= 0 && c <= 255){
                sb.append(c);
            }else{//转换UTF-8编码
                byte b[];
                try {
                    b = Character.toString(c).getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    b = null;
                }
                //转换为%HH的字符串形式
                for(int j = 0; j < b.length; j ++){
                    int k = b[j];
                    if(k < 0){
                        k &= 255;
                    }
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }

}
