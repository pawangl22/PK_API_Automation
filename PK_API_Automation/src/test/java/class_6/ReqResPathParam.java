package class_6;

import io.restassured.RestAssured;

public class ReqResPathParam {

	public static void main(String[] args) {
		String url = "https://reqres.in/api/users/{userID}";
		
		RestAssured
			.given()
				.pathParam("userID", 3)
			.when()
				.log().all()
				.get(url)
			.then()
				.log().body()
				.statusCode(200);

	}

}
