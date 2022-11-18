package kodlama.io.Devs.webApi.contrellers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstratcs.TechnologyService;
import kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.technology.GetAllTechnologiesResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
	private TechnologyService technologyService;

	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequests) throws Exception {
		technologyService.add(createTechnologyRequests);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
		technologyService.delete(deleteTechnologyRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		technologyService.update(updateTechnologyRequest);
	}
	
	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getAll() {
		return technologyService.getAll();
	}

}
