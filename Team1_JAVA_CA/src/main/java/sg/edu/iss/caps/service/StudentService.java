package sg.edu.iss.caps.service;

import java.util.ArrayList;

import sg.edu.iss.caps.domain.Enrolment;

public interface StudentService {

	public ArrayList<Enrolment>listEnrolmentByCourseId(String courseId);
}
