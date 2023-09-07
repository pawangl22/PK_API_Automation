
package class_7;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class ReqResInlineHeaderValidation {

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
				.header("Server", Matchers.equalTo("cloudflare"))
				.header("Content-Type", Matchers.equalTo("application/json; charset=utf-8"))
				.header("Connection", Matchers.containsString("alive"));
		
	}

}
