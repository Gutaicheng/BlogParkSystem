package com.gutaicheng.controller;

import com.gutaicheng.model.Article;
import com.gutaicheng.model.Pending;
import com.gutaicheng.service.PendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class PendingController {
    @Autowired
    public PendingService pendingService;

    /**
     * 新增审核记录
     */
    @RequestMapping(value = "/addPending", method = RequestMethod.POST)
    @ResponseBody
    public void addPending(@RequestBody Pending pending) {
        pendingService.addPending(pending);
    }

    /**
     * 查询所有审核记录
     */
    @RequestMapping(value = "/selectAllPending")
    @ResponseBody
    public List<Pending> selectAllPending() {
        return pendingService.selectAllPending();
    }

    /**
     * 根据 uid 获取 审核记录
     */
    @RequestMapping(value = "/selectPendingByUid")
    @ResponseBody
    public List<Pending> selectPendingByUid(int uid) {
        return pendingService.selectPendingByUid(uid);
    }
}
