package csv.dal.dao;

import java.util.Set;

import csv.dal.beans.CourseVO;

public interface CourseDAO {
	/**
	 * this method store course list into COURSE_INFO table
	 * 
	 * @param list
	 * @return
	 */
	public String createCourseList(Set<CourseVO> list) ;
	
}
