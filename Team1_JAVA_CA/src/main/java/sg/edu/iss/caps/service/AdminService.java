package sg.edu.iss.caps.service;

import java.util.ArrayList;

import sg.edu.iss.caps.domain.Enrolment;



public interface AdminService
{
	public ArrayList<Enrolment> findAllEnrollment();

	public Enrolment findEnrollmentById(int id);

	public void saveEnrollment(Enrolment enroll);

	public void deletefacility(Enrolment enroll);
}
