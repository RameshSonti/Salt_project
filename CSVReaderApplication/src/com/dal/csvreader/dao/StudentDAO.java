package com.dal.csvreader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.dal.csvreader.beans.StudentCourse;
import com.dal.csvreader.beans.Student;
import com.dal.csvreader.util.MySQLConnector;

/**
 * This class provide functionalities to communicate with db for Student data
 * 
 *
 */
public class StudentDAO {
	/**
	 * This method take student list and store in STUDENT_INFO table
	 * 
	 * @param list
	 * @return
	 */
	public String insertStudentInfo(Set<Student> list) {
		// get new connection
		Connection connection = MySQLConnector.createNewConnection();
		try {
			String insertQuery = "INSERT INTO demo.STUDENT_INFO (STUDENT_ID, FIRST_NAME, LAST_NAME,ADDRESS, ZIP_CODE, PRIMARY_PHONE_NUMBER) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(insertQuery);

			for (Student studentInfo : list) {

				stmt.setInt(1, studentInfo.getStudentId());
				stmt.setString(2, studentInfo.getFirstName());
				stmt.setString(3, studentInfo.getLastName());
				stmt.setString(4, studentInfo.getAddress());
				stmt.setString(5, studentInfo.getZipCode());
				stmt.setString(6, studentInfo.getPrimaryPhoneNumber());
				stmt.addBatch();
			}
			stmt.executeBatch();
			return "Studentinfo saved";

		} catch (SQLException e) {
			System.err.println(e);
			return "Exception occured while save student info" + e.getMessage();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String insertStudentCourseList(List<StudentCourse> list) {
		Connection connection = MySQLConnector.createNewConnection();
		try {
			String query = "INSERT INTO STUDENT_COURSE_LIST (STUDENT_ID,COURSE_ID,FINAL_GRADE) values(?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			for (StudentCourse studentCourseInfo : list) {
				ps.setInt(1, studentCourseInfo.getStudentId());
				ps.setInt(2, studentCourseInfo.getCourseId());
				ps.setString(3, studentCourseInfo.getFinalGrade());
				ps.addBatch();
			}
			ps.executeBatch();
			return "Successfully Saved";
		} catch (SQLException e) {
			System.err.println(e);
			return "Exception occured while storing studentCourseInfo " + e.getMessage();
		} finally {
			try {
				// close connection
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
