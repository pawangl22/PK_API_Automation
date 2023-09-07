package class_9;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GitHubDeleteRepo {

	public static void main(String[] args) {


		String url = "https://api.github.com/repos/{owner}/{repoName}";
		
		RestAssured
			.given()
				.pathParam("owner", "orgpawanapivalidation")
				.pathParam("repoName", "repo_api_April23_02")
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer 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")
			.when()
				.log().all()
				.delete(url)
			.then()
				.log().all()
				.and().assertThat()
					.statusCode(204);

	}

}
