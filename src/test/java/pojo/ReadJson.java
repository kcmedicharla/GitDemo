package pojo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson {
	
	public static void main(String args[]) throws StreamReadException, DatabindException, IOException {
		
		String[] expected = {"Selenium Web Driver", "Cypress", "Protractor"};
		
		ObjectMapper oM = new ObjectMapper();
		
		GetCourse getCourse = oM.readValue(new File("D:\\Rest Assured_Trainings\\jsonForPojo.json"), GetCourse.class);
		
		System.out.println(getCourse.getExpertise());
		System.out.println(getCourse.getServices());
		System.out.println(getCourse.getInstructor());
		System.out.println(getCourse.getLinkedIn());
		System.out.println(getCourse.getUrl());
		Courses courses = getCourse.getCourses();
		List<WebAutomation> webCourses = courses.getWebAutomation();
		List<ApiAutomation> apiCourses = courses.getApiAutomation();
		List<MobileAutomation> mobileCourses = courses.getMobileAutomation();
		
		/*
		System.out.println(webCourses.size());
		System.out.println(apiCourses.size());
		System.out.println(mobileCourses.size());
		
		*/
		ArrayList<String> listOfCourses = new ArrayList<String>();
		
		List<WebAutomation> web = getCourse.getCourses().getWebAutomation();
		
		for (WebAutomation webAutomation : web) {
			
			
			
			listOfCourses.add(webAutomation.getCourseTitle());
			
			//System.out.println(webAutomation.getCourseTitle());
		}
		
	    List<String> expectedList = Arrays.asList(expected);
	    
	    Assert.assertTrue(listOfCourses.equals(expectedList));
		
		/*
		for (MobileAutomation mobileAutomation : mobileCourses) {
			
			System.out.println(mobileAutomation.getCourseTitle());
			System.out.println(mobileAutomation.getPrice());
			
		}
		
		System.out.println(getCourse.getCourses().getApiAutomation().get(1).getCourseTitle());
		System.out.println(getCourse.getCourses().getApiAutomation().get(1).getPrice());
		
		List<ApiAutomation> api = getCourse.getCourses().getApiAutomation();
		
		for (ApiAutomation apiAutomation : api) {
			
			if(apiAutomation.getCourseTitle().equalsIgnoreCase("GraphQL")) {
				
				System.out.println(apiAutomation.getPrice());
			}
			
		}*/
		
		
		
		
	}

}
