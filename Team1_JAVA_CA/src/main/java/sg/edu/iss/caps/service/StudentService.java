package sg.edu.iss.caps.service;

import java.util.ArrayList;

import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.domain.Student;

public interface StudentService {


	public ArrayList<Enrolment>listEnrolmentByCourseId(String courseId);
	public ArrayList<Enrolment>listEnrolmentByStudentId(String studentId);
	public Student getStudentByEmail(String email);

}
