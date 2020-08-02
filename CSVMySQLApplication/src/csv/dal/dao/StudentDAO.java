package csv.dal.dao;

import java.util.List;
import java.util.Set;

import csv.dal.beans.StudentCourseVO;
import csv.dal.beans.StudentVO;

public interface StudentDAO {
	/**
	 * This method take student list and store in STUDENT_INFO table
	 * 
	 * @param list
	 * @return
	 */
	public String insertStudentInfo(Set<StudentVO> list);

	public String insertStudentCourseList(List<StudentCourseVO> list);

}
