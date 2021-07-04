package sg.edu.iss.caps.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.repo.EnrolmentRepository;

@Service
public class AdminServiceImpl implements AdminService 
{
	@Autowired
	EnrolmentRepository erepo;

	@Transactional
	public ArrayList<Enrolment> findAllEnrollment() {
		return (ArrayList<Enrolment>) erepo.findAll();
	}

	@Transactional
	public Enrolment findEnrollmentById(int id) {
		return erepo.findById(id).get();
	}

	@Transactional
	public void saveEnrollment(Enrolment enroll) {
		erepo.save(enroll);
		
	}
	
	public Enrolment findEnrolmentByCourseAndStudentId(String studentid,String courseid)
	{
		return erepo.findEnrolmentByCourseAndStudentId(studentid, courseid);
	}

	@Transactional
	public void deletefacility(Enrolment enroll) {
		erepo.delete(enroll);
		
	}

}
