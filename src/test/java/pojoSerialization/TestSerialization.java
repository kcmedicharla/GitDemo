package pojoSerialization;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class TestSerialization {
	
	public static void main(String args[]) {
		
		Place pl = new Place();
		
		List<String> ty = new ArrayList<String>();
		
		ty.add("new park1");
		ty.add("shop1");
		
		GetLocation loc = new GetLocation();
		
		loc.setLat(-38.7334);
		loc.setLng(-45.6667);
		
		pl.setLocation(loc);
		pl.setTypes(ty);
		pl.setAccuracy(20);
		pl.setName("Krishna1");
		pl.setPhone_number("9999999991");
		pl.setAddress("New Address1");
		pl.setWebsite("krishna1.com");
		pl.setLanguage("Telugu1");
		
		
		RestAssured.baseURI ="https://rahulshettyacademy.com";
		
		Response response = given().log().all().queryParam("key", "qaclick123")
		
		.body(pl)
		
		.when().post("maps/api/place/add/json")
		
		.then().assertThat().statusCode(200).extract().response();
		
		JsonPath js = new JsonPath(response.asString());
		
		System.out.println(js.get("place_id"));
		
		
		
	}

}
