package DemoProject.RestAssuredDemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DemoProject.files.ReusableMethods;
import DemoProject.files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	@Test(dataProvider = "Books data")
	public void addBook(String isbn, String aisle) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		String addBookResponse = given().log().all().header("Content-Type","application/json")
		.body(payload.libraryAddBook(isbn,aisle))
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(addBookResponse);
		
		JsonPath addedBookJson = ReusableMethods.rawToJson(addBookResponse);
		
		System.out.println(addedBookJson.get("ID"));
		
		//delete book
		
		String deleteBook = given().header("Content-Type","application/json")
		.body("{\r\n"
				+ " \r\n"
				+ "\"ID\" : \""+addedBookJson.get("ID")+"\"\r\n"
				+ " \r\n"
				+ "} ")
		.when().post("Library/DeleteBook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(deleteBook);
		
	}
	
	@DataProvider(name = "Books data")
	
	public Object[][] getData() {
		
		//multidimensional array = collection of arrays
		return new Object[][] {{"kc", "1273"}, {"kamal", "1274"}, {"srikanth", "1276"}};
		//return new Object[][] {{"kc", "1273", ""}};
		
	}

}
