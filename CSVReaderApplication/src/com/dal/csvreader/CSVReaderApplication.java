package com.dal.csvreader;

import java.util.List;
import java.util.Set;

import com.dal.csvreader.beans.Course;
import com.dal.csvreader.beans.StudentCourse;
import com.dal.csvreader.beans.Student;
import com.dal.csvreader.dao.CourseDAO;
import com.dal.csvreader.dao.StudentDAO;

public class CSVReaderApplication {

	public static void main(String[] args) {

		CSVFileHandler csvReader = new CSVFileHandler();

		Set<Student> studentSet = csvReader.readStudentInfoCSVFile();
		List<StudentCourse> studentCourses = csvReader.readStudentCourseInfoFile();
		Set<Course> course = csvReader.readCourseInfoFile();

		CourseDAO courseDAO = new CourseDAO();
		System.out.println(courseDAO.createCourseList(course));


		StudentDAO studentDAO = new StudentDAO();
		System.out.println(studentDAO.insertStudentInfo(studentSet));
		System.out.println(studentDAO.insertStudentCourseList(studentCourses));

	}
}
