package sg.edu.iss.caps.service;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService
{

	
<<<<<<< HEAD
	@Autowired
	EnrolmentRepository erepo;
	
	@Transactional
	public ArrayList<Enrolment> listEnrolmentByCourseId(String id){
		return erepo.findEnrolmentByCourseId(id);
	}
=======
>>>>>>> refs/remotes/origin/Genesis
}
