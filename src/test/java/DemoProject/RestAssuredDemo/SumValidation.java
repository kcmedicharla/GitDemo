package DemoProject.RestAssuredDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import DemoProject.files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
	public void sumOfCourses() {
		
		int purchaseAmountCalculated = 0;
		
		JsonPath js = new JsonPath(payload.coursePrice());
		
		for(int i=0; i<js.getInt("courses.size()"); i++) {
			
			int price = js.get("courses["+i+"].price");
			int copies = js.get("courses["+i+"].copies");
			
			int totalPriceOfEach = price*copies;
			
			System.out.println("Purchase Amount for "+ js.get("courses["+i+"].title")+" is: "+totalPriceOfEach);
			
			purchaseAmountCalculated = totalPriceOfEach+purchaseAmountCalculated;
		}
		
		System.out.println("Total purchase amount is: "+ purchaseAmountCalculated);
		
		Assert.assertEquals(purchaseAmountCalculated, js.get("dashboard.purchaseAmount"));
	}

}
