package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstratcs.CourseService;
import kodlama.io.Devs.dataAccess.abstracts.CourseRepository;
import kodlama.io.Devs.entities.concretes.Course;

@Service
public class CourseManager implements CourseService {
	private CourseRepository courseRepository;
	
	@Autowired
	public CourseManager(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public void add(Course course) {
		courseRepository.add(course);
	}

	@Override
	public void delete(int id) {
		courseRepository.delete(id);
	}

	@Override
	public void update(Course course, int id) {
		courseRepository.update(course, id);
	}

	@Override
	public List<Course> getAll() {
		return courseRepository.getAll();
	}

	@Override
	public String getId(int id) {
		return courseRepository.getId(id);
	}

}
