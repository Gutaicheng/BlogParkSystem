package com.gutaicheng.service;

import com.gutaicheng.model.Message;

import java.util.List;

public interface MessageService {
    void addMessage(Message message);

    List<Message> selectMessageByAid(int aid);
}
