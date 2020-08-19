package com.dal.jms.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dal.jms.beans.Employee;

@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${dal.rabbitmq.exchange}")
	private String exchange;

	@Value("${dal.rabbitmq.routingkey}")
	private String routingkey;

	public void send(Employee employee) {
		rabbitTemplate.convertAndSend(exchange, routingkey, employee);
		System.out.println("Send msg = " + employee);
	}
}
