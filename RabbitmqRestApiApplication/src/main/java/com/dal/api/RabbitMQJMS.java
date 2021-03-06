package com.dal.api;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dal.api.pojo.Message;

@Service
public class RabbitMQJMS {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${message.rabbitmq.exchange}")
	private String exchange;

	@Value("${message.rabbitmq.routingkey}")
	private String routingkey;

	public void send(Message message) {
		rabbitTemplate.convertAndSend(exchange, routingkey, message);
		System.out.println("Send msg = " + message);
	}
}
