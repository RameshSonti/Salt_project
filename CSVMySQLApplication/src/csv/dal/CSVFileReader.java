package csv.dal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import csv.dal.beans.CourseVO;
import csv.dal.beans.StudentVO;
import csv.dal.beans.StudentCourseVO;
import csv.dal.util.CSVReaderConstants;
/**
 * This class handle csv file 
 * 
 *
 */
public class CSVFileReader {


	/**
	 * This method read student info from csv file and return Set object. Set does
	 * not allow duplicate
	 * 
	 * @return
	 */
	public Set<StudentVO> readStudentInfoCSVFile() {

		Set<StudentVO> list = new HashSet<StudentVO>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(CSVReaderConstants.STUDENT_INFO_CSV));
			br.readLine();// read first line which contains header
			String line = null;
			while ((line = br.readLine()) != null) // returns a Boolean value there is a line
			{
				String[] student = line.split(","); // use comma as separator
				StudentVO std = new StudentVO(Integer.parseInt(student[0]), student[1], student[2], student[3],
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

	public List<StudentCourseVO> readStudentCourseInfoFile() {

		List<StudentCourseVO> list = new ArrayList<StudentCourseVO>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(CSVReaderConstants.STUDENT_COURSE_INFO_CSV));
			br.readLine();// read header
			String line = null;

			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] student = line.split(","); // use comma as separator
				StudentCourseVO std = new StudentCourseVO(Integer.parseInt(student[0]),
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

	public Set<CourseVO> readCourseInfoFile() {
		Set<CourseVO> list = new HashSet<CourseVO>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(CSVReaderConstants.COURSE_INFO));
			br.readLine();// read header
			String line = null;

			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] course = line.split(","); // use comma as separator
				CourseVO courseInfo = new CourseVO(Integer.parseInt(course[0]), Integer.parseInt(course[1]),
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
