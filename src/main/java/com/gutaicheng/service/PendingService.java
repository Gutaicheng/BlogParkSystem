package com.gutaicheng.service;

import com.gutaicheng.model.Pending;

import java.util.List;

public interface PendingService {
    void addPending(Pending pending);

    List<Pending> selectAllPending();

    List<Pending> selectPendingByUid(int uid);
}
