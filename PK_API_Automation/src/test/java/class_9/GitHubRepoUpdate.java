package class_9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GitHubRepoUpdate {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileInputStream fis = new FileInputStream("githubupdaterepo.json");
		String url = "https://api.github.com/repos/{owner}/{repoName}";
		
		RestAssured
			.given()
				.pathParam("owner", "orgpawanapivalidation")
				.pathParam("repoName", "repo_api_April23_02")
				.header("Authorization", "Bearer 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")
				.contentType(ContentType.JSON)
				.body(fis)
			.when()
				.log().all()
				.patch(url)
			.then()
				.log().all()
				.and().assertThat()
					.statusCode(200);
			

	}

}
