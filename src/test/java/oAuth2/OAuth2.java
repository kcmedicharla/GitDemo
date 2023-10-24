package oAuth2;

import static io.restassured.RestAssured.*;

public class OAuth2 {
	
	public static void main(String args[]) {
		
		/*
		String accessToken = given().queryParams("code", "4%2F0AZEOvhW3K5hs031zwcvI0PgdWFyz3NDoNd6vRxwImVmkweaR4y4B1HsBQR4uf0AHfDzKRg")
		.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type", "authorization_code")
		
		.when().post("https://www.googleapis.com/oauth2/v4/token")
		*/
		
		
		
		
		//getting the final response
		
		String response = given().queryParam("access_token", "")
		
		.when().get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(response);
	}

}
