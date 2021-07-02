package sg.edu.iss.caps.service;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javassist.bytecode.Descriptor.Iterator;
import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.CourseLecturer;
import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.domain.Lecturer;
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
	public String findLecturerbyEmail(String email)
	{
		return lrepo.findLecturerIdbyEmail(email);
	}
	
	//Gen addded for grade a course 
		 @Transactional 
		 public Optional<Enrolment> findByEnrolmentId(int id)
		 { 
		  return erepo.findById(id);
		 }
	
	//Genesis Student Performance  
	 @Transactional  
	 public List<Enrolment> listAll(String keyword){ 
		  if (keyword != null) { 
		   return erepo.search(keyword); 
		  } 
		  return erepo.findAll(); 
		 }
	
	@Transactional
	public ArrayList<Course> listAllcourses(){
		return (ArrayList<Course>)crepo.findAll();
	}
	
	@Transactional
	public Course findCourseById(String id) {
		return crepo.findById(id).get();
	}

	
	@Transactional 
	public ArrayList<Course> findCoursesByLecturerId(String id) {
		return clrepo.listCoursesByLecturerId(id);
	}
	
	@Transactional
	public ArrayList<Enrolment>listEnrolmentByCourseId(String id){
		return erepo.findEnrolmentByCourseId(id);
	}
	
	@Transactional
	public Enrolment listEnrolmentByEnrolmentId(int id){
		return erepo.findById(id).get();
	}
	
	@Transactional
	public void saveUpdatedGrades(Enrolment enrolment)
	{
		erepo.save(enrolment);

	}

	@Override
	public Object listEnrolmentByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findLecturerIdbyEmail(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findCourseNamesByLecturerId(int lecturerId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional 
	 public ArrayList<String> findAllCourseName(){ 
	  List<Course> courses = crepo.findAll(); 
	  ArrayList<String> names = new ArrayList<String>(); 
	  for(ListIterator<Course> iterator = courses.listIterator(); iterator.hasNext();) { 
	   //New obj to store the next iterated value in the list 
	   Course course = (Course) iterator.next(); 
	   //Store into created list of names 
	   names.add(course.getCourseName()); 
	  } 
	  return names; 
	}
	 
	 @Transactional  
	 public ArrayList<String> findAllLecturerNames() { 
	  List<Lecturer> lecturers = lrepo.findAll(); 
	  ArrayList<String> names = new ArrayList<String>(); 
	  
	
	  
	  for(ListIterator<Lecturer> iterator = lecturers.listIterator(); iterator.hasNext();) { 
	   Lecturer lecturer = (Lecturer) iterator.next(); 
	   names.add(lecturer.getFirstName()); 
	  } 
	  return names; 
	 } 
	
	 
		
		  @Transactional public Lecturer findLecturerByName(String firstName)
		  { 
			  return lrepo.findLecturerByFirstName(firstName.trim()).get(0);
			  }
		
		  @Transactional 
		  public Lecturer findLecturerById(String id)
		  { 
		   return lrepo.findById(id).get(); 
		  }
		  
	 @Transactional 
	 public Course findCourseByName(String name)
	 { 
	  return crepo.findCoursesByName1(name).get(0); 
	 }
	//Select courses taught by a particular lecturer using lectureremail
	@Transactional
	public List<CourseLecturer> listCourseNamesByLecturerEmail (String lectureremail) {
		return clrepo.listCourseNamesByLecturerEmail(lectureremail);
	}
	
	
	
	@Transactional 
	 public void addCousesTaught(CourseLecturer lct) { 
	  clrepo.save(lct); 
	 }
	/*
	 * //Genesis Student Performance
	 * 
	 * @Transactional public List<Enrolment> listAll(String keyword){ if (keyword !=
	 * null) { return erepo.search(keyword); } return erepo.findAll(); }
	 */
}
