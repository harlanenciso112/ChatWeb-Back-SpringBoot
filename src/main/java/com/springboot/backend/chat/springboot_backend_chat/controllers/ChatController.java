package com.springboot.backend.chat.springboot_backend_chat.controllers;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.springboot.backend.chat.springboot_backend_chat.models.Message;

@Controller
public class ChatController {
    // Configurar ruta al destino | ruta:/app
    // Publicar mensaje | Ruta para enviar mensajes
    @MessageMapping("/message")
    // Recibir mensajes de todos los usuarios | Notifica
    @SendTo("/chat/message")
    // Recive mensaje para guardar en DB
    // y para enviar a todos los usuarios
    public Message receiveMessage(Message message){
        message.setDate(new Date().getTime());
        message.setText(message.getText());
        if(message.getType().equals("NEW_USER")){
            message.setText("Nuevo usuario conectado");
        }
        return message;
    }
}
