package validar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepsValidar {

	@Test
	public void validarStatusCode() {
	RequestSpecification request = RestAssured.given().auth().preemptive().basic("", "");
	request.header("Content-Type", "application/json");
	Response response = request.get("https://inm-test-api.herokuapp.com//empregado/list/1111");
	int statusCode = response.getStatusCode();
	assertEquals(202, statusCode);
	
	}
	
	public void validarBody() {
	RequestSpecification request = RestAssured.given().auth().preemptive().basic("", "");
	request.header("Content-Type", "application/json");
	Response response = request.get("https://inm-test-api.herokuapp.com//empregado/list/1111");
	String bodyrequest = response.asString();	
    System.out.println(bodyrequest);
    String name = "Qa Pleno";
    assertTrue(bodyrequest.contains(name));
		
	}

}
