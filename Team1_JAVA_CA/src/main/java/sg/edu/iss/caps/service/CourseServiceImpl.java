package sg.edu.iss.caps.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository crepo;
	
	//Select all courses in course table 
	@Transactional
	public ArrayList<Course> listAllcourses(){
		return (ArrayList<Course>)crepo.findAll();
	}
	
	//Select course name by course Id 
	@Transactional
	public Course findCourseById(int id) {
		return crepo.findById(id).get();
	}
}
