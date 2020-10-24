package eu.dbortoluzzi.atms.controller;

import eu.dbortoluzzi.atms.model.AtmIndexable;
import eu.dbortoluzzi.atms.repository.AtmsRepository;
import eu.dbortoluzzi.atms.repository.AtmsRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AtmsController {
	@Autowired
	private AtmsRepositoryCustom atmsRepositoryCustom;
	@Autowired
	private AtmsRepository atmsRepository;

	public AtmsController(AtmsRepositoryCustom atmsRepositoryCustom, AtmsRepository atmsRepository) {
		this.atmsRepositoryCustom = atmsRepositoryCustom;
		this.atmsRepository = atmsRepository;
	}

	@RequestMapping(value = "/api/atms",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin
	public AtmsResponse getAtms() {
		List<AtmIndexable> atms = atmsRepository.findAll();

		AtmsResponse response = new AtmsResponse(atms, Long.valueOf(atms.size()));

		return response;
	}

	@GetMapping("/api/atms/search/{query}/{page}/{size}")
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin
	public AtmsResponse getAtmsByQuery(@PathVariable  String query, @PathVariable  Integer page, @PathVariable Integer size) {
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<AtmIndexable> pageResponse = atmsRepositoryCustom.search(query, pageRequest);
		pageResponse.getContent();

		AtmsResponse response = new AtmsResponse(pageResponse.getContent(), pageResponse.getTotalElements());
		response.setAtms(pageResponse.getContent());

		return response;
	}
}
