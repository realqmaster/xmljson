package org.my.test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import io.restassured.http.Header;
import io.restassured.response.Response;
import java.io.IOException;

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
  
  @Test
  void contextAude() throws Exception {

    Response xmlResponse =
        given()
            .log()
            .all()
            .body(new ClassPathResource("vitt2.xml").getFile())
            .header(new Header("content-type", "application/xml"))
            .header(new Header("accept", "text/plain"))
            .when()
            .post("/aude")
            .thenReturn();

    assertNotNull(xmlResponse);
    assertEquals(200,xmlResponse.statusCode());
  }
  
}
