package csv.dal.beans;

/**
 * 
 *This class is mapped to student_course_info table
 */
public class StudentCourseVO {

	private int studentId;
	private int courseId;
	private String finalGrade;

	public StudentCourseVO(int studentId, int courseId, String finalGrade) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
		this.finalGrade = finalGrade;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(String finalGrade) {
		this.finalGrade = finalGrade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
		result = prime * result + studentId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentCourseVO other = (StudentCourseVO) obj;
		if (courseId != other.courseId)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentCourseInfo [studentId=" + studentId + ", courseId=" + courseId + ", finalGrade=" + finalGrade
				+ "]";
	}

}
