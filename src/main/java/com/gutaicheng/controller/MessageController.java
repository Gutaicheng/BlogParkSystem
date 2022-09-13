package com.gutaicheng.controller;

import com.gutaicheng.model.Message;
import com.gutaicheng.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * 新增评论
     */
    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    @ResponseBody
    public void addMessage(@RequestBody Message message) {
        messageService.addMessage(message);
    }

    /**
     * 根据 aid 查询该文章下的所有评论
     */
    @RequestMapping(value = "/selectMessageByAid")
    @ResponseBody
    public List<Message> selectMessageByAid(int aid) {
        return messageService.selectMessageByAid(aid);
    }
}
