package com.springboot.backend.chat.springboot_backend_chat.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.backend.chat.springboot_backend_chat.models.Message;

@Service
public class MessageServiceImpl implements MessageService{

    private List<Message> messages = new ArrayList<>();

    @Override
    public List<Message> findAll() {
        return messages;
    }

    @Override
    public void save(Message message) {
        messages.add(message);
    }


}
