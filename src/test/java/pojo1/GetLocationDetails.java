package pojo1;

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

public class GetLocationDetails {
	
	public static void main(String args[]) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		GetPlace getP = given().queryParam("key", "qaclick123")
		.queryParam("place_id", "bc1693468f8ab1bf4517af43f2db3a4c")
		
		.when().get("maps/api/place/get/json")
		
		.then().extract().response().as(GetPlace.class);
		
		System.out.println(getP.getLocation().getLatitude());
		System.out.println(getP.getLocation().getLongitude());
		System.out.println(getP.getAccuracy());
		System.out.println(getP.getAddress());
		System.out.println(getP.getLanguage());
		System.out.println(getP.getName());
		System.out.println(getP.getPhone_number());
		System.out.println(getP.getTypes());
		System.out.println(getP.getWebsite());
	
	}

}
