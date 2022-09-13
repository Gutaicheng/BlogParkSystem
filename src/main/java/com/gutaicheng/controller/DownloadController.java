package com.gutaicheng.controller;

import com.gutaicheng.model.Download;
import com.gutaicheng.service.DownloadService;
import com.gutaicheng.util.DocUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class DownloadController {
    @Autowired
    private DownloadService downloadService;

    /**
     *上传文件资源
     */
    @RequestMapping(value = "/addDownload", method = RequestMethod.POST)
    @ResponseBody
    public String addDownload(HttpServletRequest request, MultipartFile myfile) throws IOException {
        String dfile;
        dfile = DocUtil.upload(request,myfile);
        if (dfile != null){
            System.out.println("文件不为空：路径==》"+dfile);
//            download.setDfile(dfile);
            System.out.println("上传成功");
            return dfile;
//            downloadService.addDownload(download);
        }else {
            System.out.println("文件为空，上传失败");
            return null;
        }
    }

    /**
     * 上传文件资源详情
     */
    @RequestMapping(value = "/uploadDownload", method = RequestMethod.POST)
    @ResponseBody
    public void uploadDownload(@RequestBody Download download){
        downloadService.uploadDownload(download);
    }

    /**
     * 查询所有待审核  资源
     */
    @RequestMapping(value = "/selectAllDownloadsPending")
    @ResponseBody
    public List<Download> selectAllDownloads(){
        return downloadService.selectAllDownloads();
    }

    /**
     * 下载资源
     */
    @RequestMapping("/downdown")
    @ResponseBody
    public String downdown(String lfile, HttpServletRequest request, HttpServletResponse response){
        return DocUtil.download(lfile, request, response);
    }

    /**
     * 更改资源状态
     */
    @RequestMapping(value = "/updateDownloadState")
    @ResponseBody
    public void updateDownloadState(int did, int state){
        downloadService.updateDownloadState(did,state);
    }

    /**
     * 查询 下载量前十的 资源
     */
    @RequestMapping(value = "/topTenDownload")
    @ResponseBody
    public List<Download> topTenDownload(){
        return downloadService.topTenDownload();
    }

    /**
     * 查询 前十的 最新资源
     */
    @RequestMapping(value = "/topNewDownload")
    @ResponseBody
    public List<Download> topNewDownload(){
        return downloadService.topNewDownload();
    }

    /**
     * 根据 uid 获取该用户上传的资源
     */
    @RequestMapping(value = "/selectDownloadByUid")
    @ResponseBody
    public List<Download> selectDownloadByUid(int uid){
        return downloadService.selectDownloadByUid(uid);
    }

    /**
     * 根据 did 删除资源
     */
    @RequestMapping(value = "/deleteDownloadByDid")
    @ResponseBody
    public void deleteDownloadByDid(int did){
        downloadService.deleteDownloadByDid(did);
    }
}
