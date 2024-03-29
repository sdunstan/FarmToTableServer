package com.hackday.farmtotable.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/farm-to-table-websocket").setAllowedOrigins("*").withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry broker) {
		broker.enableSimpleBroker("/topic");
		broker.setApplicationDestinationPrefixes("/app");
	}
}
