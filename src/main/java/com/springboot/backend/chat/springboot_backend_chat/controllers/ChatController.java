package com.springboot.backend.chat.springboot_backend_chat.controllers;

import java.util.Date;
import java.util.Random;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.springboot.backend.chat.springboot_backend_chat.models.Message;

@Controller
public class ChatController {

    private String[] colors = {"yellow", "red", "orange", "purple", "magenta", "blue", "green"};

    // Configurar ruta al destino | ruta:/app
    // Publicar mensaje | Ruta para enviar mensajes
    @MessageMapping("/message")
    // Recibir mensajes de todos los usuarios | Notifica
    @SendTo("/chat/message")
    // Recive mensaje para guardar en DB
    // y para enviar a todos los usuarios

    public Message receiveMessage(Message message){
        message.setDate(new Date().getTime());
        
        if(message.getType().equals("NEW_USER")){
            message.setColor(this.colors[new Random().nextInt(colors.length)]);
            message.setText("Nuevo usuario conectado");
        }

        if(message.getType().equals("USER_DISCONNECT")){
            message.setText("Se ha desconectado");
        }
        return message; 
    }
    // Se envia a /app/writing
    @MessageMapping("/writing")
    @SendTo("/chat/writing")
    public String isWritString(String username){
        return username.concat(" esta escribiendo...");
    }
}
