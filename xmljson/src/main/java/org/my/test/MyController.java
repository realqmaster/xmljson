package org.my.test;

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
}
