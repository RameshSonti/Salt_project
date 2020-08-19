package com.dal.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dal.restapi.service.RabbitMQRequestHandler;

@RestController
@RequestMapping(value = "topic/")
public class TopicController {
	@Autowired
	RabbitMQRequestHandler rabbitMQRequestHandler;

	@GetMapping(value = "/chat/{message}")
	public String sender(@PathVariable("message") String message) {
		rabbitMQRequestHandler.send(message);
		return "Message sent to the RabbitMQ Successfully";
	}
}
