package com.dal.csv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.dal.csv.entity.CourseInfo;
import com.dal.csv.util.ConnectionUtil;

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
	public String saveCourseList(Set<CourseInfo> list) {
		// get new connection
		Connection connection = ConnectionUtil.getNewConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO demo.COURSE_INFO (COURSE_ID, PROFESSOR_ID, NAME, CREDITS) VALUES (?, ?, ?, ?)");

			for (CourseInfo courseInfo : list) {

				ps.setInt(1, courseInfo.getCourseId());
				ps.setInt(2, courseInfo.getProfessorId());
				ps.setString(3, courseInfo.getName());
				ps.setInt(4, courseInfo.getCredits());
				ps.addBatch();

			}
			ps.executeBatch();
			return "Course List successfully stored";
		} catch (SQLException e) {
			System.err.println(e);
			return "Exception occured while save course list " + e.getMessage();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
