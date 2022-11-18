package kodlama.io.Devs.business.abstratcs;

import java.util.List;

import kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.technology.GetAllTechnologiesResponse;

public interface TechnologyService {
	void add(CreateTechnologyRequest createTechnologyRequests) throws Exception;
	void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception;
	void update(UpdateTechnologyRequest updateTechnologyRequest) throws Exception;
	List<GetAllTechnologiesResponse> getAll();
}
