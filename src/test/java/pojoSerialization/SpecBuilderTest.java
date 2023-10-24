package pojoSerialization;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class SpecBuilderTest {
	
	public static void main(String args[]) {
		
		Place pl = new Place();
		
		List<String> ty = new ArrayList<String>();
		
		ty.add("new park2");
		ty.add("shop2");
		
		GetLocation loc = new GetLocation();
		
		loc.setLat(-38.7334);
		loc.setLng(-45.6667);
		
		pl.setLocation(loc);
		pl.setTypes(ty);
		pl.setAccuracy(20);
		pl.setName("Krishna3");
		pl.setPhone_number("9999999993");
		pl.setAddress("New Address3");
		pl.setWebsite("krishna3.com");
		pl.setLanguage("Telugu3");
		
		RequestSpecification  reqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();
		
		
		//RestAssured.baseURI ="https://rahulshettyacademy.com";
		
		RequestSpecification req = given().spec(reqSpec).body(pl);
		
		Response response = req.when().post("maps/api/place/add/json")
		
		.then().log().all().spec(resSpec).extract().response();
		
		JsonPath js = new JsonPath(response.asString());
		
		System.out.println(js.get("place_id"));
		
		
		
	}

}
