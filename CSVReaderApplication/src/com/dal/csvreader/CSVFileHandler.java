package com.dal.csvreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dal.csvreader.beans.Course;
import com.dal.csvreader.beans.StudentCourse;
import com.dal.csvreader.util.CSVReaderConstants;
import com.dal.csvreader.beans.Student;
/**
 * This class handle csv file 
 * 
 *
 */
public class CSVFileHandler {


	/**
	 * This method read student info from csv file and return Set object. Set does
	 * not allow duplicate
	 * 
	 * @return
	 */
	public Set<Student> readStudentInfoCSVFile() {

		Set<Student> list = new HashSet<Student>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(CSVReaderConstants.STUDENT_INFO_CSV));
			br.readLine();// read first line which contains header
			String line = null;
			while ((line = br.readLine()) != null) // returns a Boolean value there is a line
			{
				String[] student = line.split(","); // use comma as separator
				Student std = new Student(Integer.parseInt(student[0]), student[1], student[2], student[3],
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

	public List<StudentCourse> readStudentCourseInfoFile() {

		List<StudentCourse> list = new ArrayList<StudentCourse>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(CSVReaderConstants.STUDENT_COURSE_INFO_CSV));
			br.readLine();// read header
			String line = null;

			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] student = line.split(","); // use comma as separator
				StudentCourse std = new StudentCourse(Integer.parseInt(student[0]),
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

	public Set<Course> readCourseInfoFile() {
		Set<Course> list = new HashSet<Course>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(CSVReaderConstants.COURSE_INFO));
			br.readLine();// read header
			String line = null;

			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] course = line.split(","); // use comma as separator
				Course courseInfo = new Course(Integer.parseInt(course[0]), Integer.parseInt(course[1]),
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
