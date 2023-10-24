package DemoProject.RestAssuredDemo;

import DemoProject.files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(payload.coursePrice());
		
		//1. Print No of courses returned by API
		
		int count = js.getInt("courses.size()");
		
		System.out.println("Number of courses: "+count);
		
		// 2.Print Purchase Amount
		
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		
		System.out.println("Purchase amount is: "+purchaseAmount);
		
		//3. Print Title of the first course
		
		String titleFirstCourse = js.get("courses[1].title");
		
		System.out.println(titleFirstCourse);
		
		//System.out.println(js.getString("courses[1]"));
		
		//4. Print All course titles and their respective Prices
		
		for(int i=0;i<count;i++) {
			
			System.out.println(js.get("courses["+i+"].title")+", "+js.get("courses["+i+"].price"));
			
		}
		
		//5. Print no of copies sold by RPA Course
		
		for(int i=0;i<count;i++) {
			
			String courseTitle = js.get("courses["+i+"].title");
			
			if(courseTitle.equalsIgnoreCase("Appium")) {
				
				System.out.println("Number of copies sold for RPA: "+ js.get("courses["+i+"].copies"));
				
				break;
			}
			
		}
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		
		

	}

}
