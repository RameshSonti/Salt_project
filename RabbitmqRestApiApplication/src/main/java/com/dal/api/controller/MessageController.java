package com.dal.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dal.api.RabbitMQJMS;
import com.dal.api.pojo.Message;

@RestController
@RequestMapping(value = "message/")
public class MessageController {
	@Autowired
	RabbitMQJMS rabbitMQSender;

	@GetMapping(value = "/send")
	public String producer(@RequestParam("text") String text) {
		Message message = new Message(text);
		rabbitMQSender.send(message);
		return "Message sent to the RabbitMQ Successfully";
	}
}
