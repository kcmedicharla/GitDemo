package DemoProject.RestAssuredDemo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import DemoProject.files.ReusableMethods;
import DemoProject.files.payload;

public class Basics {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//covert Json in to String in below mentioned 2 steps
		//1. convert Josn in to byte data
		//2. convert byte data in to String
		
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		JsonPath initialPayload = ReusableMethods.rawToJson(GenerateStringFromJsonFile("D:\\Rest Assured_Trainings\\AddPlace.json"));
		
		String initialAddress = initialPayload.getString("address");
		
		//given - essentially the params, header and body
		
		String response = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(GenerateStringFromJsonFile("D:\\Rest Assured_Trainings\\AddPlace.json"))
		//when - resource and HTTP method
		
		.when().post("maps/api/place/add/json")
		
		//then - validate response
		
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js = ReusableMethods.rawToJson(response);
		
		String place = js.getString("place_id");
		
		System.out.println("Place id is: "+ place);
		
		//Add place -> Update place with new address -> Get place to validate 
		//if new address is present in response
		
		String newAddress = "Latest updated address sample";
		
		String updatedResponse = given().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n"
				+ "\"place_id\":\""+place+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		
		.when().put("maps/api/place/update/json")
		
		
		.then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated")).header("Server", "Apache/2.4.52 (Ubuntu)")
		
		.extract().response().asString();
		
		System.out.println("updated response is: "+ updatedResponse);
		
		//Get updated place and verify
		
		
		String updatedPayLoad = given().queryParam("key", "qaclick123")
		.queryParam("place_id", place)
		
		.when().get("maps/api/place/get/json")
		
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		JsonPath updatedPayLoad_Json = ReusableMethods.rawToJson(updatedPayLoad);
		
		String updatedAddress = updatedPayLoad_Json.getString("address");
		
		System.out.println("Initial Address is: "+ initialAddress);
		
		System.out.println("Trying to update the address with: "+newAddress);
		
		System.out.println("Updated the address with: "+ updatedAddress);
		
		//Assert.assertEquals(updatedAddress, "something new");
		
		Assert.assertEquals(updatedAddress, newAddress);

	}
	
	public static String GenerateStringFromJsonFile(String path) throws IOException {
		
		return new String(Files.readAllBytes(Paths.get(path)));
		
	}

}
