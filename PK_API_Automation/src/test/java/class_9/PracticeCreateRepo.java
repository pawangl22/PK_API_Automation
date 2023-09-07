package class_9;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PracticeCreateRepo {

	public static void main(String[] args) {
		
		String url = "https://api.github.com/orgs/{owner}/repos";
		PracticeCreateRepoPOJO repo = new PracticeCreateRepoPOJO();
		repo.setName("repo_api_April23_04");
		
		RestAssured
		.given()
			.pathParam("owner", "orgpawanapivalidation")
			.header("Authorization", "Bearer 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")
			.contentType(ContentType.JSON)
			.body(repo)
		.when()
			.log().all()
			.post(url)
		.then()
			.log().all()
			.and().assertThat()
				.statusCode(201);
		
	
	}

}
