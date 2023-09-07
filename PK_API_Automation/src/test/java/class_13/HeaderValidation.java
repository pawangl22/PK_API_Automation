package class_13;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;

public class HeaderValidation {
	

	public static void main(String[] args) {
		
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		builder.expectHeader("Server", Matchers.equalTo("cloudflare"));
		builder.expectHeader("Content-Type", Matchers.equalTo("application/json; charset=utf-8"));
		
		RestAssured.responseSpecification = builder.build();
		String url = "https://reqres.in/api/users/{userID}";
		
		RestAssured
			.given()
				.pathParam("userID", 3)
			.when()
				.log().all()
				.get(url)
			.then()
				.log().all()
				.statusCode(200);

	}

}
