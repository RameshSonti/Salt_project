package csv.dal;

import java.util.List;
import java.util.Set;

import csv.dal.beans.CourseVO;
import csv.dal.beans.StudentVO;
import csv.dal.beans.StudentCourseVO;
import csv.dal.dao.CourseDAOImpl;
import csv.dal.dao.StudentDAOImpl;

public class CSVMySQLApplication {

	public static void main(String[] args) {

		CSVFileReader csvReader = new CSVFileReader();

		Set<StudentVO> studentSet = csvReader.readStudentInfoCSVFile();
		List<StudentCourseVO> studentCourses = csvReader.readStudentCourseInfoFile();
		Set<CourseVO> course = csvReader.readCourseInfoFile();

		CourseDAOImpl courseDAO = new CourseDAOImpl();
		System.out.println(courseDAO.createCourseList(course));


		StudentDAOImpl studentDAO = new StudentDAOImpl();
		System.out.println(studentDAO.insertStudentInfo(studentSet));
		System.out.println(studentDAO.insertStudentCourseList(studentCourses));

	}
}
