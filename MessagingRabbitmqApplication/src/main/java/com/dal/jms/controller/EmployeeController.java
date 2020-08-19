package com.dal.jms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dal.jms.beans.Employee;
import com.dal.jms.service.RabbitMQSender;

@RestController
@RequestMapping(value = "employee/")
public class EmployeeController {
	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/create")
	public String producer(@RequestParam("empId") String empId, @RequestParam("empName") String empName) {
		Employee emp = new Employee(empId, empName);
		// send employee to queue ,which will be consumed by consumer from query
		rabbitMQSender.send(emp);
		return "Employee Data sent to the RabbitMQ Successfully";
	}
}
