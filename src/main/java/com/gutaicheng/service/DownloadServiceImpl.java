package com.gutaicheng.service;


import com.gutaicheng.dao.DownloadMapper;
import com.gutaicheng.model.Download;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("downloadService")
public class DownloadServiceImpl implements DownloadService{
    @Resource
    private DownloadMapper downloadMapper;


    /**
     * 上传文件资源详情
     */
    @Override
    public void uploadDownload(Download download) {
        downloadMapper.uploadDownload(download);
    }

    /**
     * 查询所有待审核  资源
     */
    @Override
    public List<Download> selectAllDownloads() {
        return downloadMapper.selectAllDownloads();
    }

    /**
     * 更改资源状态
     */
    @Override
    public void updateDownloadState(int did, int state) {
        downloadMapper.updateDownloadState(did,state);
    }

    /**
     * 查询 下载量前十的 资源
     */
    @Override
    public List<Download> topTenDownload() {
        return downloadMapper.topTenDownload();
    }

    /**
     * 查询 最新 前十的资源
     */
    @Override
    public List<Download> topNewDownload() {
        return downloadMapper.topNewDownload();
    }

    /**
     * 根据 uid 获取该用户上传的资源
     */
    @Override
    public List<Download> selectDownloadByUid(int uid) {
        return downloadMapper.selectDownloadByUid(uid);
    }

    /**
     * 根据 did 删除资源
     */
    @Override
    public void deleteDownloadByDid(int did) {
        downloadMapper.deleteDownloadByDid(did);
    }

}
