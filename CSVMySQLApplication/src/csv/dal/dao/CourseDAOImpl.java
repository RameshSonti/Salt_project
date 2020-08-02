package csv.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import csv.dal.beans.CourseVO;
import csv.dal.util.MySQLConnectionHandler;

/**
 * 
 * This class communicate db for course CRUD operation
 *
 */
public class CourseDAOImpl implements CourseDAO{
	public String createCourseList(Set<CourseVO> list) {
		// get new connection
		Connection con = MySQLConnectionHandler.createNewConnection();
		try {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO demo.COURSE_INFO (COURSE_ID, PROFESSOR_ID, NAME, CREDITS) VALUES (?, ?, ?, ?)");

			for (CourseVO course : list) {

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
