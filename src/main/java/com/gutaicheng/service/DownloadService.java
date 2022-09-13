package com.gutaicheng.service;

import com.gutaicheng.model.Download;

import java.util.List;

public interface DownloadService {

    void uploadDownload(Download download);

    List<Download> selectAllDownloads();

    void updateDownloadState(int did, int state);

    List<Download> topTenDownload();

    List<Download> topNewDownload();

    List<Download> selectDownloadByUid(int uid);

    void deleteDownloadByDid(int did);
}
