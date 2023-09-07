package class_7;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class ReqResInlineBodyArraySoftValidation {

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
					.body("data[1].email", Matchers.equalTo("janet.weaver@reqres.in"),
					"data.email", Matchers.hasItem("tracey.ramos@reqres.i"),
					"data.email", Matchers.hasItems("charles.morris@reqres.in","eve.Holt@reqres.in"),
					"data.email", Matchers.contains("janet.weaver@reqres.in", "emma.wong@reqres.in", "eve.holt@reqres.in", "charles.morris@reqres.in", "tracey.ramos@reqres.in"),
					"data.email", Matchers.containsInAnyOrder("george.bluth@reqres.in", "janet.weaver@reqres.in", "emma.wong@reqres.in", "eve.holt@reqres.in", "tracey.ramos@reqres.in", "charles.morris@reqres.in"));
		}

	}