package class_8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PracticeCreateGitHubRepo {

	public static void main(String[] args) throws FileNotFoundException {

		FileInputStream fis = new FileInputStream("githubcreaterepo.json");
		String url = "https://api.github.com/orgs/{owner}/repos";
		
		RestAssured
		.given()
			.pathParam("owner", "orgpawanapivalidation")
			.header("Authorization", "Bearer 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")
			.contentType(ContentType.JSON)
			.body(fis)
		.when()
			.log().all()
			.post(url)
		
		.then()
			.log().body()
			.and().assertThat()
			.statusCode(201);
	}

}
