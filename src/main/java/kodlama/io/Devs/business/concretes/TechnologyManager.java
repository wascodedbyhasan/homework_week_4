package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstratcs.TechnologyService;
import kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.technology.GetAllTechnologiesResponse;
import kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{
	private TechnologyRepository technologyRepository;
	
	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository) {
		super();
		this.technologyRepository = technologyRepository;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequests) throws Exception {
		if(createTechnologyRequests.getName().isEmpty()) {
			throw new Exception("Teknoloji ismi boş olamaz.");
		}
		for(Technology technology : technologyRepository.findAll()) {
			if(technology.getName().equals(createTechnologyRequests.getName())) {
				throw new Exception("Teknoloji adı tekrar edemez.");
			}
		}
		Technology technology = new Technology();
		technology.setName(createTechnologyRequests.getName());
		technologyRepository.save(technology);
		
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		for (GetAllTechnologiesResponse getAllTechnologiesResponse : getAll()) {
			if(getAllTechnologiesResponse.getId() == deleteTechnologyRequest.getId()) {
				technologyRepository.deleteById(deleteTechnologyRequest.getId());
			}
		}
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
		Technology technology = new Technology();
		for (Technology technologyItem : technologyRepository.findAll()) {
			if(technologyItem.getName().equals(updateTechnologyRequest.getName())) {
				throw new Exception("Dil adı zaten kullanımda.");
			}
			if(updateTechnologyRequest.getId() == technologyItem.getId()) {
				technology.setId(updateTechnologyRequest.getId());
				technology.setName(updateTechnologyRequest.getName());
				technologyRepository.save(technology);
			}
		}
	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologiesResponse> technologiesResponses = new ArrayList<>();
		for(Technology technology : technologies) {
			GetAllTechnologiesResponse responseItem = new GetAllTechnologiesResponse();
			responseItem.setId(technology.getId());
			responseItem.setName(technology.getName());
			technologiesResponses.add(responseItem);
		}
		return technologiesResponses;
	}

}
