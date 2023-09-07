package class_10;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GitHubRepoUpdateTest {

	public static void main(String[] args) {
		
		String url = "https://api.github.com/repos/{owner}/{repoName}";
		
		GitHubUpdateRepoPOJO obj = new GitHubUpdateRepoPOJO();
		obj.setDescription("This has been updated with serialization [2]");
		obj.setPrivateVal(false);
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
				.log().all()
				.and().assertThat()
					.statusCode(200);
			

	}

}
