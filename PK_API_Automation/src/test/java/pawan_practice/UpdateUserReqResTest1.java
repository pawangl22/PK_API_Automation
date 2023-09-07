package pawan_practice;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateUserReqResTest1 {

	public static void main(String[] args) {
		
		UpdateUserRequestPOJO req = new UpdateUserRequestPOJO();
		req.setName("Kumar");
		req.setJob("Senior Manager");
		
		//UpdateUserResponsePOJO res = new UpdateUserResponsePOJO();
		
		String url = "https://reqres.in/api/users/2";
		
		 UpdateUserResponsePOJO res = RestAssured
			.given()
				.body(req)
				.contentType(ContentType.JSON)
			.when()
				.log().all()
				.put(url)
			.then()
				.log().all()
				.and().assertThat()
				.statusCode(200)
				.extract().as(UpdateUserResponsePOJO.class);
		 
		 String name = res.getName();
		 String job = res.getJob();
		 String updated = res.getUpdatedAt();
		 MatcherAssert.assertThat(name, Matchers.equalToIgnoringCase(name));
		 MatcherAssert.assertThat(job, Matchers.equalToIgnoringCase(job));
		 MatcherAssert.assertThat(updated, Matchers.equalToIgnoringCase(updated));
	}

}
