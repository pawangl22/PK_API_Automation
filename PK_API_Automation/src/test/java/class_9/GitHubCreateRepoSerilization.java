package class_9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GitHubCreateRepoSerilization {

	public static void main(String[] args) throws FileNotFoundException {

		//URL, AUTH, PATH PARAM, BODY

		String url = "https://api.github.com/orgs/{owner}/repos";
		
		GitHubCreateRepoPOJO obj = new GitHubCreateRepoPOJO();
		obj.setName("repo_api_April23_04");
		
		RestAssured
			.given()
				.pathParam("owner", "orgpawanapivalidation")
				.header("Authorization", "Bearer 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")
				.contentType(ContentType.JSON)
				.body(obj)
			.when()
				.log().all()
				.post(url)
			.then()
				.log().all()
				.and().assertThat()
					.statusCode(201);

	}

}
