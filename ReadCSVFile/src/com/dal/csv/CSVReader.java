package com.dal.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dal.csv.entity.CourseInfo;
import com.dal.csv.entity.StudentCourseInfo;
import com.dal.csv.entity.StudentInfo;

public class CSVReader {

	private static final String STUDENT_INFO_CSV = "student_info.csv";
	private static final String COURSE_INFO = "course-info.csv";
	private static final String STUDENT_COURSE_INFO_CSV = "student-course-list.csv";

	/**
	 * This method read student info from csv file and return Set object. Set does
	 * not allow duplicate
	 * 
	 * @return
	 */
	public Set<StudentInfo> readStudentInfoCSV() {

		Set<StudentInfo> list = new HashSet<StudentInfo>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(STUDENT_INFO_CSV));
			br.readLine();// read header
			String line = null;

			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] student = line.split(","); // use comma as separator
				StudentInfo std = new StudentInfo(Integer.parseInt(student[0]), student[1], student[2], student[3],
						student[4], student[5]);
				list.add(std);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<StudentCourseInfo> readStudentCourseInfo() {

		List<StudentCourseInfo> list = new ArrayList<StudentCourseInfo>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(STUDENT_COURSE_INFO_CSV));
			br.readLine();// read header
			String line = null;

			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] student = line.split(","); // use comma as separator
				StudentCourseInfo std = new StudentCourseInfo(Integer.parseInt(student[0]),
						Integer.parseInt(student[1]), student[2]);
				list.add(std);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Set<CourseInfo> readCourseInfo() {
		Set<CourseInfo> list = new HashSet<CourseInfo>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(COURSE_INFO));
			br.readLine();// read header
			String line = null;

			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] course = line.split(","); // use comma as separator
				CourseInfo courseInfo = new CourseInfo(Integer.parseInt(course[0]), Integer.parseInt(course[1]),
						course[2], Integer.parseInt(course[3]));
				list.add(courseInfo);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}
}
