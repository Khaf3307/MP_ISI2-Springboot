package com.esmt.sn.mpisi2.entities;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Course {
	public Course() {

	}
	@SuppressWarnings("unused")
	private Long id;
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private List<Student> students;
	
	
}
