package DemoProject.files;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class JiraTest {
	
	public static void main(String args[]) {
		
		RestAssured.baseURI = "http://localhost:8081/";
		
		SessionFilter sessionFilter = new SessionFilter();
		
		//establish connection
		
		/* Add the below thing to your given while establishing the connection with HTTPS protocol. 
		 * If you do not have proper HTTPS validation certificates available, then this will take care of HTTPS 
		 * authentication
		 */
		
		//given().relaxedHTTPSValidation()
		
		given().header("Content-Type", "application/json").body("{ \"username\": \"kistimalli\", "
				+ "\"password\": \"Kisti@123\" }").log().all().filter(sessionFilter)
		
		.when().post("rest/auth/1/session")
		
		
		.then().assertThat().statusCode(200).extract().response().asString();
		
		//add comment
		
		String comment = "Hi, how are you? To test the latest comment last";
		
		String addCommentResponse = given().pathParam("key", "RES-2").header("Content-Type", "application/json").body("{\r\n"
				+ "    \"body\": \""+comment+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(sessionFilter).log().all()
		
		.when().post("rest/api/2/issue/{key}/comment")
		
		.then().assertThat().statusCode(201).extract().response().asString();
		
		JsonPath jsAddCommentResponse = new JsonPath(addCommentResponse);
		
		String commentId = jsAddCommentResponse.get("id");
		
		//add attachment
		/*
		given().header("X-Atlassian-Token", "no-check").filter(sessionFilter).pathParam("key", "RES-2")
		.multiPart("file", new File("jira.txt")).header("Content-Type", "multipart/form-data")
		
		.when().post("/rest/api/2/issue/{key}/attachments")
		
		.then().assertThat().statusCode(200).log().all(); */
		
		//get issue
		
		String issueDetails = given().filter(sessionFilter).pathParam("key", "RES-2").queryParam("fields", "comment")
		
		.when().get("rest/api/2/issue/{key}")
		
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(issueDetails);
		
		int commentsCount = js.get("fields.comment.comments.size()");
		
		for(int i=0; i<commentsCount; i++) {
			
			String commentIdIteration = js.getString("fields.comment.comments["+i+"].id");
			
			//System.out.println(commentIdIteration);
			
			 String commentBodyMine = js.get("fields.comment.comments["+i+"].body");
			
			if(commentIdIteration.equalsIgnoreCase(commentId)) {
				
				String commentBody = js.get("fields.comment.comments["+i+"].body");
				
				System.out.println("Here is the comment which you added latest: "+commentBody);
				
				System.out.println("Here is the id of the comment which you added latest: "+commentIdIteration);
				
				Assert.assertEquals(commentBody, comment);
				
			}
			/*
			if(commentBodyMine.equalsIgnoreCase("Comment on my third Jira defect_2_Updated_1211")) {
				
				System.out.println("Found the comment while uploading the attachment: "+commentBodyMine );
				
				System.out.println("The id of the comment while uploading attachment is: "+commentIdIteration );
				
			}*/
			
		}
		
	}

}
