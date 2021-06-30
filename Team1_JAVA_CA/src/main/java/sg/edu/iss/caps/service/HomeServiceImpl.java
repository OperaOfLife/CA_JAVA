package sg.edu.iss.caps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.repo.CourseRepository;

@Service
public class HomeServiceImpl implements HomeService
{
	@Autowired
	CourseRepository crepo;

	@Override
	public Page<Course> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) 
	{
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.crepo.findAll(pageable);
	}

	
}
