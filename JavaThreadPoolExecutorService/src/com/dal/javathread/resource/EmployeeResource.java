package com.dal.javathread.resource;

import java.util.ArrayList;
import java.util.List;

import com.dal.javathread.bean.Employee;

public class EmployeeResource {

	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("E001", "E1", 54999));
		list.add(new Employee("E002", "E2", 55999));
		list.add(new Employee("E003", "E3", 5545));
		list.add(new Employee("E004", "E4", 59554));
		list.add(new Employee("E005", "E5", 354549));
		list.add(new Employee("E006", "E6", 5454));
		list.add(new Employee("E007", "E7", 54629));
		list.add(new Employee("E008", "E8", 34229));
		return list;

	}
}
