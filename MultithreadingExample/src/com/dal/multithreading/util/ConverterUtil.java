package com.dal.multithreading.util;

import com.dal.multithreading.pojo.Student;
import com.google.gson.Gson;

/**
 * This class provide functionalities to convert json to java and vice versa
 *
 */
public class ConverterUtil {

	private static Gson gson = new Gson();

	public static String javaToJson(Student student) {
		return gson.toJson(student);
	}
}
