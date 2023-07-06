package com.esmt.sn.mpisi2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.esmt.sn.mpisi2.entities.Course;
import com.esmt.sn.mpisi2.entities.Student;

@Controller
public class CourseController{

	private List<Course> courses;

	public CourseController() {

		courses = new ArrayList<>();

		Course course1 =  new Course();
		course1.setId(1L);
		course1.setName("Modern Java EE - Spring");
		course1.setStudents(new ArrayList<>());

		Course course2 =  new Course();
		course2.setId(2L);
		course2.setName("Architecture logicielle");
		course2.setStudents(new ArrayList<>());

		Course course3 =  new Course();
		course3.setId(3L);
		course3.setName("Data Mining");
		course3.setStudents(new ArrayList<>());

		Course course4 =  new Course();
		course4.setId(4L);
		course4.setName("Data WareHouse");
		course4.setStudents(new ArrayList<>());

		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		courses.add(course4);
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("courses", courses);
		return "index";
	}

	@GetMapping("/course/{id}")
	public String courseDetails(@PathVariable("id") Long id, Model model) {
	    Course course = findCourseById(id);
	    model.addAttribute("course", course);
	    model.addAttribute("newStudent", new Student()); // Add this line
	    return "course";	
	}

	@PostMapping("/course/addStudent")
	public String addStudentToCourse(@ModelAttribute("newStudent") Student newStudent, @RequestParam("courseID") Long courseId) {
		Course course = findCourseById(courseId);
		course.getStudents().add(newStudent);
		return "redirect:/course/" + courseId;
	}

	private Course findCourseById(long id) {
		return courses.stream().filter(course -> course.getId().equals(id)).findFirst().orElse(null);
	}
}
