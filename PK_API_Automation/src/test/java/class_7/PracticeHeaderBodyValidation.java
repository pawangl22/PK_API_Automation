package class_7;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class PracticeHeaderBodyValidation {

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
				.header("connection", Matchers.equalTo("keep-alive"))
				.header("Content-Type", Matchers.equalTo("application/json; charset=utf-8"))
				.body("data.id", Matchers.equalTo(2))
				.body("data.email", Matchers.equalTo("janet.weaver@reqres.in"));
	}

}
