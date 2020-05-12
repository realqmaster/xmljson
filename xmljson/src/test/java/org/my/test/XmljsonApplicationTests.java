package org.my.test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.restassured.http.Header;

class XmljsonApplicationTests {

  String json =
      "{\"cards\": [{\"number\":1, \"seam\":\"squares\"},{\"number\":1, \"seam\":\"hearts\"}]}";
  String xml =
      "<deck><cards><card><number>1</number><seam>\"squares\"</seam></card><card><number>1</number><seam>\"hearts\"</seam></card></cards></deck>";

  @Test
  void contextLoads() {

    String jsonResponse =
        given()
            .log()
            .all()
            .body(json)
            .header(new Header("content-type", "application/json"))
            .header(new Header("accept", "text/plain"))
            .when()
            .post("/deck")
            .thenReturn()
            .asString();

    String xmlResponse =
        given()
            .log()
            .all()
            .body(xml)
            .header(new Header("content-type", "application/xml"))
            .header(new Header("accept", "text/plain"))
            .when()
            .post("/deck")
            .thenReturn()
            .asString();

    assertEquals(jsonResponse, xmlResponse);
  }
}
