package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.CourseRepository;
import kodlama.io.Devs.entities.concretes.Course;

@Repository
public class InMemoryCourseRepository implements CourseRepository {
	List<Course> courses;

	public InMemoryCourseRepository() {
		courses = new ArrayList<Course>();
		courses.add(new Course(1, "C#"));
		courses.add(new Course(2, "Java"));
		courses.add(new Course(3, "Phyton"));
	}

	@Override
	public void add(Course course) {
		courses.add(course);
	}

	@Override
	public void delete(int id) {
		courses.remove(id);
	}

	@Override
	public void update(Course course, int id) {
		
	}

	@Override
	public List<Course> getAll() {
		return courses;
	}

	@Override
	public String getId(int id) {
		for (Course course : courses) {
			if(course.getId() == id) {
				return course.getName();
			}
		}
		String errorMessage = "Bulunamadı.";
		return errorMessage;
	}
}
