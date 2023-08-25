package com.hyomee.demo.requrstandresponse.websocketStomp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.AbstractWebSocketMessage;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

// 웹 소켓 구성 한다. Configure Spring for STOMP messaging
// 1. WebSocket 기능을 사용하도록 설정 : @EnableWebSocketMessageBroker
// 2.
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


  public void configureMessageBroker(MessageBrokerRegistry config) {
    //
    config.enableSimpleBroker("/topic");
    config.setApplicationDestinationPrefixes("/app");
  }


  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/gs-guide-websocket");
  }

}
