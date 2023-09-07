package class_5;

import io.restassured.RestAssured;

public class FirstRestAssuredCode {

	public static void main(String[] args) {

		RestAssured
			.given()
			.when()
				.log().all()
				.get("https://reqres.in/api/users/2")
			.then()
				.log().all()
				.statusCode(200);

	}

}
