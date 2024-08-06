package com.in28mintues.springboot.learn_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@RequestMapping("/courses")
	public List<Course> retrieveCourses() {
		return Arrays.asList(
			new Course(1, "WebDev", "AngelaYu"),
			new Course(2, "MasterSpring", "Ranga")
			);
		
	}
}
