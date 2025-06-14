package com.springboot.backend.chat.springboot_backend_chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.lang.NonNull;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(@NonNull StompEndpointRegistry registry) {
                // Ruta para conectarse al servidor desde el Front
        registry.addEndpoint("/chat-websocket")
                // Origin de angular - puerto de angular 4200
                .setAllowedOrigins("http://localhost:4200")
                // Trabajar con cliente withSockJS por el lado de angular
                // Comunicarse con el protocolo http hacia el backen col la ruta ""/chat-websocket""
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(@NonNull MessageBrokerRegistry registry) {
        // Suscribirse
        // Escuchando que llegue un mensaje
        registry.enableSimpleBroker("/chat/");
        // Enviar mensaje al back
        registry.setApplicationDestinationPrefixes("/app");
    }
    
}
