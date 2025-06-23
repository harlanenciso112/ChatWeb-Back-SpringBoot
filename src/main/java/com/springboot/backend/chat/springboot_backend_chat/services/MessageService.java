package com.springboot.backend.chat.springboot_backend_chat.services;

import java.util.List;

import com.springboot.backend.chat.springboot_backend_chat.models.Message;

public interface MessageService {
    List<Message> findAll();
    void save(Message message);
}
