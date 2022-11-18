package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstratcs.LanguageService;
import kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.language.DeleteLanguageRequest;
import kodlama.io.Devs.business.requests.language.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequests) throws Exception {
		if(createLanguageRequests.getName().isEmpty()) {
			throw new Exception("Programlama dil adı boş bırakılamaz.");
		}
		for (Language language : languageRepository.findAll()) {
			if(language.getName().equalsIgnoreCase(createLanguageRequests.getName())) {
				throw new Exception("Programlama dil adı zaten mevcut.");
			}
		}
		Language language = new Language();
		language.setName(createLanguageRequests.getName());
		languageRepository.save(language);
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		for (GetAllLanguagesResponse getAllLanguagesResponse : getAll()) {
			if(getAllLanguagesResponse.getId() == deleteLanguageRequest.getId()) {
				languageRepository.deleteById(deleteLanguageRequest.getId());
			}
		}
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
		/*
		 * for (GetAllLanguagesResponse getAllLanguagesResponse : getAll()) {
		 * if(getAllLanguagesResponse.getName().equals(updateLanguageRequest.getName()))
		 * { throw new Exception("Zaten dil adı mevcut."); }
		 * if(updateLanguageRequest.getId() == getAllLanguagesResponse.getId()) {
		 * language.setId(updateLanguageRequest.getId());
		 * language.setName(updateLanguageRequest.getName());
		 * languageRepository.save(language); } }
		 */
		if(updateLanguageRequest.getName().isBlank()) {
			throw new Exception("Dil ismi boş geçilemez.");
		}
		Language language = languageRepository.findById(updateLanguageRequest.getId())
				.orElseThrow(()-> new EntityNotFoundException("Güncellenecek dil bulunamadı."));
		language.setName(updateLanguageRequest.getName());
		languageRepository.save(language);
	}
	
	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languagesResponse = new ArrayList<>();
		for(int i=0; i<languages.size(); i++) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setId(languages.get(i).getId());
			responseItem.setName(languages.get(i).getName());
			languagesResponse.add(responseItem);
		}
		return languagesResponse;
	}
	
}