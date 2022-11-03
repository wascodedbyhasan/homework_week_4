package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.Course;

public interface CourseRepository {
	void add(Course course);
	void delete(int id);
	void update(Course course, int id);
	List<Course> getAll();
	String getId(int id);
}
