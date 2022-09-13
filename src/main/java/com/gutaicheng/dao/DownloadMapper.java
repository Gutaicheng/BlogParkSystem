package com.gutaicheng.dao;

import com.gutaicheng.model.Download;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("downloadMapper")
public interface DownloadMapper {

    void uploadDownload(Download download);

    List<Download> selectAllDownloads();

    void updateDownloadState(@Param("did") int did, @Param("state") int state);

    List<Download> topTenDownload();

    List<Download> topNewDownload();

    List<Download> selectDownloadByUid(int uid);

    void deleteDownloadByDid(int did);
}
