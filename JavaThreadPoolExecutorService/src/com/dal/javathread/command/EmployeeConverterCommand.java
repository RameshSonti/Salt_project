package com.dal.javathread.command;

import com.dal.javathread.bean.Employee;
import com.google.gson.Gson;

public class EmployeeConverterCommand implements Runnable {

	private Employee employee;
	private Gson gson = new Gson();

	public EmployeeConverterCommand(Employee employee) {
		this.employee = employee;
	}

	@Override
	public void run() {
		String ctName = Thread.currentThread().getName();
		String json = gson.toJson(employee);

		System.out.println(ctName + "=>" + json);

	}

}
