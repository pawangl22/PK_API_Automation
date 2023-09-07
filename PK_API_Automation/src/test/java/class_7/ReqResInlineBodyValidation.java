package class_7;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class ReqResInlineBodyValidation {

	public static void main(String[] args) {
		String url = "https://reqres.in/api/users/{userID}";
		
		RestAssured
			.given()
				.pathParam("userID", 2)
			.when()
				.log().all()
				.get(url)
			.then()
				.log().all()
				.statusCode(200)
				.body("data.email", Matchers.equalTo("janet.weaver@reqres.in"))
				.body("data.id", Matchers.equalTo(2))
				.body("data.first_name", Matchers.equalTo("Janet"))
				.body("data.last_name", Matchers.equalToIgnoringCase("weaver"));

	}

}
