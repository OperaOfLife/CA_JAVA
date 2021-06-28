package sg.edu.iss.caps.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.repo.CourseRepository;

@Service
public class LecturerServiceImpl implements LecturerService 
{

	@Autowired
	CourseRepository crepo;
	
	//Select all courses in course table 
	@Transactional
	public ArrayList<Course> listAllcourses(){
		return (ArrayList<Course>)crepo.findAll();
	}
	
	//Select course name by course Id 
	@Transactional
	public Course findCourseById(String id) {
		return crepo.findById(id).get();
	}

	@Override
	public Object listEnrolmentByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findLecturerIdbyEmail(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object findCourseNamesByLecturerId(int lecturerId) {
		// TODO Auto-generated method stub
		return null;
	}
}
