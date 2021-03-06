package Webpages;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


import org.junit.Assert;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

public class BackendClass {
	
	static BackendClass backendObject;
	
	public static BackendClass getBackendClass() {
		if (backendObject == null)
			backendObject = new BackendClass();
		return backendObject;
		
	}
	
    public void getResponseBody() {
    	
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .when()
                .get("https://pokeapi.co/api/v2/pokemon/ditto")
                .then()
                .extract().response();
        
        //Assert if response status is 200
        Assert.assertEquals(200, response.getStatusCode());
        
        ResponseBody body = response.getBody();
        System.out.println("Response Body is: " + body.asString());
        
        //Assert that response body include property "abilities"
        List<Map<String, String>> node1 = JsonPath.from(body.asString()).get("abilities");
        Assert.assertTrue(node1.size() > 0);
        System.out.println("size of node1 is" +node1.size());
        
      //Assert that response body include property "moves"
        List<Map<String, String>> node2 = JsonPath.from(body.asString()).get("moves");
        Assert.assertTrue(node2.size() > 0);
        System.out.println("size of node1 is" +node2.size());
     }

}
