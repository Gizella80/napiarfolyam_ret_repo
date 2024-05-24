package pti.sb_napiarfolyam_rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import pti.sb_napiarfolyam_rest.dto.ChangeRateDto;

import pti.sb_napiarfolyam_rest.parser.XMLParser;

@Service
public class AppService {

	public ChangeRateDto getChnageRateToday() throws Exception {
		
		RestTemplate rt = new RestTemplate();
		
		String changeRateXml = rt.getForObject("http://api.napiarfolyam.hu/?bank=kh&valuta=eur",String.class );
		
		
		XMLParser parser = new XMLParser();
		
		ChangeRateDto rateDto = parser.getEurChangingRateToday(changeRateXml);
		
		return rateDto;
	}

}
