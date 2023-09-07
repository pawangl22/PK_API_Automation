package class_6;

import io.restassured.RestAssured;

public class GitHubQueryParam {

	public static void main(String[] args) {
		
		String url = "https://api.github.com/orgs/orgvanitha/repos";
		
		RestAssured
			.given()
				.queryParam("per_page", 2)
				.queryParam("page", 3)
				.queryParam("type", "public")
			.when()
				.log().all()
				.get(url)
			.then()
				.log().body()
				.statusCode(200);
	}

}
