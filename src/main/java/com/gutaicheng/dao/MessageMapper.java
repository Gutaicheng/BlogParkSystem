package com.gutaicheng.dao;

import com.gutaicheng.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("messageMapper")
public interface MessageMapper {
    void addMessage(Message message);

    List<Message> selectMessageByAid(int aid);
}
