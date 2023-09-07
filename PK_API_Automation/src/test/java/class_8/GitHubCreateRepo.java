package class_8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GitHubCreateRepo {

	public static void main(String[] args) throws FileNotFoundException {

		//URL, AUTH, PATH PARAM, BODY

		String url = "https://api.github.com/orgs/{owner}/repos";
		
		FileInputStream fis = new FileInputStream("githubcreaterepo.json");
		
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
				.log().all()
				.and().assertThat()
					.statusCode(201);

	}

}
