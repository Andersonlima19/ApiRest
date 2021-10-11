package Cadastro;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmpregadoController {

	@Test
	public void cadatrarFuncionario() {
    RequestSpecification request = RestAssured.given().auth().preemptive().basic("inmetrics","automacao");     	
	request.header("Content-Type","application/json");
	JSONObject bodyrequest = new JSONObject();
	
	  bodyrequest.put("admissao", "12/01/2001");
	  bodyrequest.put("cargo", "Qa Pleno");
	  bodyrequest.put("comissao", "2.000,00");
	  bodyrequest.put("cpf", "000.000.000-00");
	  bodyrequest.put("departamentoId", "1");
	  bodyrequest.put("nome", "anzo portuga");
	  bodyrequest.put("salario", "7.000,00");
	  bodyrequest.put("sexo", "m");
	  bodyrequest.put("tipoContratacao", "clt");

	  request.body(bodyrequest.toJSONString());
	  
	  Response response = request.post("https://inm-test-api.herokuapp.com/empregado/cadastrar");
	
	  System.out.println("O Retorno do cadastro é " + response.asPrettyString());
	  
	  int code = 202;
	  int CodeRetornado = response.getStatusCode();
	  assertEquals(code, CodeRetornado);
	  
	  
	}

}
