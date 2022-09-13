package com.gutaicheng.service;


import com.gutaicheng.dao.PendingMapper;
import com.gutaicheng.model.Pending;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("PendingService")
public class PendingServiceImpl implements PendingService{

    @Resource
    private PendingMapper pendingMapper;

    /**
     * 新增审核记录
     */
    @Override
    public void addPending(Pending pending) {
        pendingMapper.addPending(pending);
    }

    /**
     * 查询所有审核记录
     */
    @Override
    public List<Pending> selectAllPending() {
        return pendingMapper.selectAllPending();
    }

    /**
     * 根据 uid 获取 审核记录
     */
    @Override
    public List<Pending> selectPendingByUid(int uid) {
        return pendingMapper.selectPendingByUid(uid);
    }
}
