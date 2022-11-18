package kodlama.io.Devs.webApi.contrellers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstratcs.LanguageService;
import kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.language.DeleteLanguageRequest;
import kodlama.io.Devs.business.requests.language.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	private LanguageService languageService;
	
	@Autowired
	public LanguageController(LanguageService courseService) {
		this.languageService = courseService;
	}
	
	@PostMapping("/add")
	public void add(CreateLanguageRequest createLanguageRequests) throws Exception {
		languageService.add(createLanguageRequests);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception {
		languageService.delete(deleteLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
		languageService.update(updateLanguageRequest);
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll() {
		return languageService.getAll();
	}

}
