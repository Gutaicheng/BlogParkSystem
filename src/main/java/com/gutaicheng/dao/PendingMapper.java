package com.gutaicheng.dao;

import com.gutaicheng.model.Pending;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("pendingMapper")
public interface PendingMapper {
    /**
     * 新增审核记录
     */
    void addPending(Pending pending);

    /**
     * 查询所有审核记录
     */
    List<Pending> selectAllPending();

    /**
     * 根据 uid 获取 审核记录
     */
    List<Pending> selectPendingByUid(int uid);
}
