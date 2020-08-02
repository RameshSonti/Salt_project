package com.dal.csvreader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.dal.csvreader.beans.Course;
import com.dal.csvreader.util.MySQLConnector;

/**
 * 
 * This class communicate db for course CRUD operation
 *
 */
public class CourseDAO {

	/**
	 * this method store course list into COURSE_INFO table
	 * 
	 * @param list
	 * @return
	 */
	public String createCourseList(Set<Course> list) {
		// get new connection
		Connection con = MySQLConnector.createNewConnection();
		try {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO demo.COURSE_INFO (COURSE_ID, PROFESSOR_ID, NAME, CREDITS) VALUES (?, ?, ?, ?)");

			for (Course course : list) {

				ps.setInt(1, course.getCourseId());
				ps.setInt(2, course.getProfessorId());
				ps.setString(3, course.getName());
				ps.setInt(4, course.getCredits());
				ps.addBatch();

			}
			ps.executeBatch();
			return "Course List successfully stored";
		} catch (SQLException e) {
			System.err.println(e);
			return "Exception occured while save course list " + e.getMessage();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
