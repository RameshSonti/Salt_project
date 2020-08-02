package com.dal.multithreading.repository;

import java.util.Arrays;
import java.util.List;

import com.dal.multithreading.pojo.Student;

/**
 * 
 * This class provides student data
 *
 */
public class StudentRepository {

	public List<Student> findAll() {
		List<Student> list = Arrays.asList(new Student(121, "A", "Java", 9343), new Student(545, "B", "Python", 6555),
				new Student(166, "C", "PHP", 3333), new Student(131, "D", "String", 6643),
				new Student(671, "E", "Flutter", 33343), new Student(331, "F", "Android", 8743),
				new Student(221, "G", ".NET", 2243), new Student(661, "H", "Laravel", 4343)

		);
		return list;
	}
}
