package com.dal.restapi.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQRequestHandler {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${restapi.rabbitmq.exchange}")
	private String exchange;

	@Value("${restapi.rabbitmq.routingkey}")
	private String routingkey;

	public void send(String message) {
		rabbitTemplate.convertAndSend(exchange, routingkey, message);
		System.out.println("Send msg = " + message);
		
	}
}
