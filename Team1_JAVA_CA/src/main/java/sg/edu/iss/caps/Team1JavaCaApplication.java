package sg.edu.iss.caps;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.CourseLecturer;
import sg.edu.iss.caps.domain.Enrolment;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.repo.CourseLecturerRepository;
import sg.edu.iss.caps.repo.CourseRepository;
import sg.edu.iss.caps.repo.EnrolmentRepository;
import sg.edu.iss.caps.repo.LecturerRepository;
import sg.edu.iss.caps.repo.StudentRepository;



@SpringBootApplication
public class Team1JavaCaApplication {
	
	@Autowired
	LecturerRepository lrepo;
	
	@Autowired
	CourseLecturerRepository clrepo;
	
	@Autowired
	CourseRepository crepo;
	
	@Autowired
	StudentRepository srepo;
	
	@Autowired
	EnrolmentRepository erepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Team1JavaCaApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			
			/*
			 * Lecturer l1 = new Lecturer("L0468491A", "Yuen", "Kwan", "Chia",
			 * LocalDate.of(2015, 7, 30), "chiayuenkwan@gmail.com"); Lecturer l2 = new
			 * Lecturer("L0459013A", "Cher", "Wah", "Tan", LocalDate.of(2015, 9, 21),
			 * "tancherwah@gmail.com"); lrepo.save(l1); lrepo.save(l2);
			 * 
			 * Course c1 = new Course("JA4101", "Java",
			 * "An object oriented programming language for application development.", 65,
			 * 6, 15, LocalDate.of(2021, 01, 05)); Course c2 = new Course("AD4105", "ADLC",
			 * "Fundamentals of software analysis and design.", 85, 4, 10,
			 * LocalDate.of(2021, 01, 05)); Course c3 = new Course("FO4110", "FOPCS",
			 * "Fundamentals of programming in C#.", 85, 6, 6, LocalDate.of(2021, 01, 05));
			 * Course c4 = new Course("ML4107", "Python ML",
			 * "Python for data analysis and predictions.", 75, 8, 10, LocalDate.of(2021,
			 * 01, 05)); crepo.save(c1); crepo.save(c2); crepo.save(c3); crepo.save(c4);
			 * 
			 * CourseLecturer cl1 = new CourseLecturer(c1, l2); CourseLecturer cl2 = new
			 * CourseLecturer(c2, l2); CourseLecturer cl3 = new CourseLecturer(c3, l1);
			 * CourseLecturer cl4 = new CourseLecturer(c4, l2); clrepo.save(cl1);
			 * clrepo.save(cl2); clrepo.save(cl3); clrepo.save(cl4);
			 * 
			 * Student s1 = new Student("S0239014A", "Katherine", "Marissa", "Wong",
			 * LocalDate.of(2020, 12, 29), "katherinewong@gmail.com"); Student s2 = new
			 * Student("S0695835A", "Genesis", "Yu Xuan", "Tan", LocalDate.of(2020, 12, 16),
			 * "genesistan@gmail.com"); Student s3 = new Student("S0546891A", "Aung",
			 * "Myint", "Myatt", LocalDate.of(2020, 12, 01), "aungmyintmyatt@gmail.com");
			 * srepo.save(s1); srepo.save(s2); srepo.save(s3);
			 * 
			 * Enrolment e1 = new Enrolment(LocalDate.of(2021, 2, 1), "-", s1, c1);
			 * Enrolment e2 = new Enrolment(LocalDate.of(2021, 2, 2), "B+", s1, c2);
			 * Enrolment e3 = new Enrolment(LocalDate.of(2021, 2, 1), "-", s2, c1);
			 * Enrolment e4 = new Enrolment(LocalDate.of(2021, 2, 2), "A", s2, c2);
			 * Enrolment e5 = new Enrolment(LocalDate.of(2021, 1, 29), "A+", s2, c3);
			 * Enrolment e6 = new Enrolment(LocalDate.of(2021, 1, 16), "A-", s3, c4);
			 * erepo.save(e1); erepo.save(e2); erepo.save(e3); erepo.save(e4);
			 * erepo.save(e5); erepo.save(e6);
			 */
			
		};
	}

}
