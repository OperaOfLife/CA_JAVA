package sg.edu.iss.caps.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.repo.EnrolmentRepository;
import sg.edu.iss.caps.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{

	@Autowired
	StudentRepository srepo;
	
	@Autowired
	EnrolmentRepository erepo;
	
	@Transactional
	public ArrayList<Enrolment> listEnrolmentByCourseId(String id){
		return erepo.findEnrolmentByCourseId(id);
	}
}
