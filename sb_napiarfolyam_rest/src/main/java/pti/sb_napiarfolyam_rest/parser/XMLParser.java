package pti.sb_napiarfolyam_rest.parser;


import java.io.IOException;
import java.io.StringReader;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Repository;
import pti.sb_napiarfolyam_rest.dto.ChangeRateDto;



@Repository
public class XMLParser {
	
	
	public ChangeRateDto getEurChangingRateToday(String changeRateXml) throws JDOMException, IOException {
		
		ChangeRateDto rateDto = null;
		
		SAXBuilder sb = new SAXBuilder();
		
		StringReader reader = new StringReader(changeRateXml);
		
		Document document = sb.build(reader);
		
		
		
		Element arfolyamokRootElement = document.getRootElement();
		Element valutaElement = arfolyamokRootElement.getChild("valuta");
		Element itemElement = valutaElement.getChild("item");
		
			
		Element penznemElement = itemElement.getChild("penznem");
		Element vetelElement = itemElement.getChild("vetel");
		String penznem = penznemElement.getValue();
		String rate = vetelElement.getValue();	
		
		
		double changeRateD = Double.parseDouble(rate);
		int changeRate = (int)Math.round(changeRateD);
		
		rateDto = new ChangeRateDto(changeRate,penznem);
			
		
		
		return rateDto;
	}


}
