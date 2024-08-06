package com.in28mintues.springboot.learn_spring_boot;

public class Course {
	private long id;
	private String courseName;
	private String authorName;
	
	public Course(long id, String courseName, String authorName) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.authorName = authorName;
	}

	public long getId() {
		return id;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getAuthorName() {
		return authorName;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", authorName=" + authorName + "]";
	}
	
}
