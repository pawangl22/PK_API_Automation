package pawan_practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateRepoTest1 {

	public static void main(String[] args) {
		
		String url = "https://api.github.com/repos/{owner}/{repoName}";
		UpdateRepoPOJO1 obj = new UpdateRepoPOJO1();
		obj.setDescription("Printing");
		obj.setPrivateValue(true);
		
		RestAssured
		.given()
			.pathParam("owner", "orgpawanapivalidation")
			.pathParam("repoName", "repo_api_April23_03")
			.header("Authorization", "Bearer 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")
			.contentType(ContentType.JSON)
			.body(obj)
		.when()
			.log().all()
			.patch(url)
		.then()
			.log().body()
			.and().assertThat()
				.statusCode(200);
		
		
	}

}
