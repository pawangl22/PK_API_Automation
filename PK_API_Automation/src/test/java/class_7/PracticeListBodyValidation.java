package class_7;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class PracticeListBodyValidation {

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
			.statusCode(200)
			.body("total_pages", Matchers.equalTo(2),
			"data.email[0]", Matchers.equalTo("george.bluth@reqres.in"),
			"data.first_name", Matchers.hasItem("Eve"),
			"data.last_name", Matchers.hasItems("Morris","Holt"),
			"data.id", Matchers.containsInAnyOrder(5,6,2,3,4,1));
		
	}

}
