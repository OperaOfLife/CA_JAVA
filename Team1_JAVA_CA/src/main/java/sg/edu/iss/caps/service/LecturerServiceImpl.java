package sg.edu.iss.caps.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.repo.CourseLecturerRepository;
import sg.edu.iss.caps.repo.CourseRepository;
import sg.edu.iss.caps.repo.EnrolmentRepository;
import sg.edu.iss.caps.repo.LecturerRepository;

@Service
public class LecturerServiceImpl implements LecturerService {

	
	@Autowired
	LecturerRepository lrepo;
	
	@Autowired
	CourseRepository crepo;
	
	@Autowired 
	CourseLecturerRepository clrepo;	
	
	@Autowired
	EnrolmentRepository erepo;
	
	@Transactional
	public int findLecturerIdbyEmail(String email) {
		return lrepo.findLecturerIdbyEmail(email);
	}
	
	@Transactional
	public ArrayList<Course> listAllcourses(){
		return (ArrayList<Course>)crepo.findAll();
	}
	
	@Transactional
	public Course findCourseById(int id) {
		return crepo.findById(id).get();
	}
	
	@Transactional 
	public ArrayList<Course> findCourseNamesByLecturerId(int id) {
		return clrepo.listCourseNamesByLecturerId(id);
	}
	
	@Transactional
	public ArrayList<Enrolment>listEnrolmentByCourseId(int id){
		return erepo.findEnrolmentByCourseId(id);
	}
}
