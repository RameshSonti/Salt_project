package com.dal.multithreading.pojo;

public class Student {

	private int id;
	private String name;
	private String course;
	private int fee;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String course, int fee) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.fee = fee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + ", fee=" + fee + "]";
	}

}
