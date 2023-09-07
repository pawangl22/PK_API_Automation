package class_6;

import io.restassured.RestAssured;

public class ReqResQueryParam {

	public static void main(String[] args) {
		String url = "https://reqres.in/api/users";
		
		RestAssured
			.given()
				.queryParam("page", 1)
			.when()
				.log().all()
				.get(url)
			.then()
				.log().all()
				.statusCode(200);

	}

}
