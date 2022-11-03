package kodlama.io.Devs.webApi.contrellers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstratcs.CourseService;
import kodlama.io.Devs.entities.concretes.Course;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {
	private CourseService courseService;

	public CoursesController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@GetMapping("/add")
	public void add(Course course) {
		courseService.add(course);
	}
	
	@GetMapping("/delete")
	public void delete(int id) {
		courseService.delete(id);
	}
	
	@GetMapping("/update")
	public void update(Course course, int id) {
		courseService.update(course, id);
	}
	
	@GetMapping("/getall")
	public List<Course> getAll() {
		return courseService.getAll();
	}
	
	@GetMapping("/getid")
	public String getId(int id) {
		return courseService.getId(id);
	}

}
