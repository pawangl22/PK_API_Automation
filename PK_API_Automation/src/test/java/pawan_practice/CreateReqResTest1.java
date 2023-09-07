package pawan_practice;

import java.util.regex.Matcher;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateReqResTest1 {

	public static void main(String[] args) {

		String url = "https://reqres.in/api/users";
		
		CreateReqResPOJO1 obj = new CreateReqResPOJO1();
		obj.setName("Pawan");
		obj.setJob("Manager");
		
		CreateReqResPOJO1 res = RestAssured
			.given()
				.body(obj)
				.contentType(ContentType.JSON)
			.when()
				.log().all()
				.post(url)
			.then()
				.log().all()
				.and().assertThat()
				.statusCode(201).extract().as(CreateReqResPOJO1.class);
		
		int id= res.getId();
		String date = res.getCreatedAt();
		String name = res.getName();
		String job = res.getJob();
		
		MatcherAssert.assertThat(name, Matchers.equalToIgnoringCase("Pawan"));
		MatcherAssert.assertThat(job, Matchers.equalToIgnoringCase("Manager"));
		
		System.out.println(id);
		System.out.println(date);
		System.out.println(name);
		System.out.println(job);
	}

}
