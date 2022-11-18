package kodlama.io.Devs.business.abstratcs;

import java.util.List;

import kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.language.DeleteLanguageRequest;
import kodlama.io.Devs.business.requests.language.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;

public interface LanguageService {
	void add(CreateLanguageRequest createLanguageRequests) throws Exception;
	void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception;
	void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;
	List<GetAllLanguagesResponse> getAll();
}
