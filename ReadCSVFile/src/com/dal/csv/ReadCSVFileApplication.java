package com.dal.csv;

import java.util.List;
import java.util.Set;

import com.dal.csv.dao.CourseDAO;
import com.dal.csv.dao.StudentDAO;
import com.dal.csv.entity.CourseInfo;
import com.dal.csv.entity.StudentCourseInfo;
import com.dal.csv.entity.StudentInfo;

public class ReadCSVFileApplication {

	public static void main(String[] args) {

		CSVReader csvReader = new CSVReader();
		// get studentinfo set
		Set<StudentInfo> studentInfoSet = csvReader.readStudentInfoCSV();

		// get course info set
		Set<CourseInfo> courseInfoSet = csvReader.readCourseInfo();

		// get student course info list
		List<StudentCourseInfo> studentCourseInfoList = csvReader.readStudentCourseInfo();

		// -------save course info into db------

		CourseDAO courseDAO = new CourseDAO();
		System.out.println(courseDAO.saveCourseList(courseInfoSet));

		// -------save student info into db------

		StudentDAO studentDAO = new StudentDAO();
		System.out.println(studentDAO.saveStudentList(studentInfoSet));

		// -------save student course info into db------

		System.out.println(studentDAO.saveStudentCourseList(studentCourseInfoList));

	}
}
