package com.dal.multithreading;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.dal.multithreading.command.StudentCommand;
import com.dal.multithreading.pojo.Student;
import com.dal.multithreading.repository.StudentRepository;

public class MultitreadingExample {
	public static void main(String[] args) {

		StudentRepository repository = new StudentRepository();
		List<Student> studentList = repository.findAll();

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		// java 8 lambda expression
		studentList.forEach(student -> executorService.execute(new StudentCommand(student)));

	}
}
