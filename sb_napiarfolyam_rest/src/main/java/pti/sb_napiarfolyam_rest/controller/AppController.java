package pti.sb_napiarfolyam_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pti.sb_napiarfolyam_rest.dto.ChangeRateDto;
import pti.sb_napiarfolyam_rest.service.AppService;

@RestController
public class AppController {
	
	private AppService service;
	
	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/currency/eur")
	public ChangeRateDto getRateToday() throws Exception {
		ChangeRateDto rateDto = service.getChnageRateToday();
		
		return rateDto;
	}
}
