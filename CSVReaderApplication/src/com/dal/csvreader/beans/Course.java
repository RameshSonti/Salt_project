package com.dal.csvreader.beans;

public class Course {

	private int courseId;
	private int professorId;
	private String name;
	private int credits;

	public Course(int courseId, int professorId, String name, int credits) {
		super();
		this.courseId = courseId;
		this.professorId = professorId;
		this.name = name;
		this.credits = credits;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
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
		Course other = (Course) obj;
		if (courseId != other.courseId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CourseInfo [courseId=" + courseId + ", professorId=" + professorId + ", name=" + name + ", credits="
				+ credits + "]";
	}

}
