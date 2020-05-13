package org.my.test;

import com.crif.cff.commons.appraisal.models.audit.AudeAuditrequestModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @PostMapping(
      value = "deck",
      consumes = {"application/json", "application/xml"})
  public String howMany(@RequestBody Deck deck) {
    return "This deck has " + deck.getCards().size() + " cards in it";
  }
  
  @PostMapping(
	      value = "aude",
	      consumes = {"application/json", "application/xml"})
	  public String howMany(@RequestBody AudeAuditrequestModel aude) {
	    return "This deck has aude UUID " + aude.getCodapplicationcrif();
	  }
	  
}
