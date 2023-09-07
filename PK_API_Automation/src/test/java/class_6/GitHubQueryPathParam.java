package class_6;

import io.restassured.RestAssured;

public class GitHubQueryPathParam {

	public static void main(String[] args) {

		String url = "https://api.github.com/orgs/{orgName}/repos";
		
		RestAssured
			.given()
				.queryParam("per_page", 2)
				.queryParam("page", 3)
				.queryParam("type", "public")
				.pathParam("orgName", "orgvanitha")
			.when()
				.log().all()
				.get(url)
			.then()
				.log().body()
				.statusCode(200);
	}


	}
