package com.gutaicheng.service;

import com.gutaicheng.dao.MessageMapper;
import com.gutaicheng.model.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("MessageService")
public class MessageServiceImpl implements MessageService{
    @Resource
    private MessageMapper messageMapper;

    /**
     * 新增评论
     */
    @Override
    public void addMessage(Message message) {
        messageMapper.addMessage(message);
    }

    /**
     * 根据 aid 查询该文章下的所有评论
     */
    @Override
    public List<Message> selectMessageByAid(int aid) {
        return messageMapper.selectMessageByAid(aid);
    }
}
