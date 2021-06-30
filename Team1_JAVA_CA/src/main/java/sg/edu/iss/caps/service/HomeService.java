package sg.edu.iss.caps.service;

import org.springframework.data.domain.Page;

import sg.edu.iss.caps.domain.Course;

public interface HomeService 
{
	Page<Course> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
