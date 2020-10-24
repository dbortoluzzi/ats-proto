package eu.dbortoluzzi.atms.controller;

import eu.dbortoluzzi.atms.AtmsRepository;
import eu.dbortoluzzi.atms.model.AtmIndexable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AtmsController {
	private AtmsRepository atmsRepository;

	@Autowired
    AtmsController(AtmsRepository atmsRepository) {
		this.atmsRepository= atmsRepository;
	}
	
	@RequestMapping(value = "/api/atms",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public AtmsResponse getAtms() {
		List<AtmIndexable> atms = atmsRepository.findAll();
				
		AtmsResponse response = new AtmsResponse();
		response.setAtms(atms);
		
		return response;
	}

	@RequestMapping(value = "/api/atms/search",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public AtmsResponse getAtmsByQuery(@RequestParam String query) {
		List<AtmIndexable> atms = atmsRepository.findByQuery(query);

		AtmsResponse response = new AtmsResponse();
		response.setAtms(atms);

		return response;
	}
}
