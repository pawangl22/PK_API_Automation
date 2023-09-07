package class_8;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class GitHubHeaderBodyValidation {

	public static void main(String[] args) {
		
		String url = "https://api.github.com/repos/{owner}/{repoName}";
		
		RestAssured
			.given()
				.pathParam("owner", "orgpawanapivalidation")
				.pathParam("repoName", "repo_pk_restassured")
			.when()
				.log().all()
				.get(url)
			.then()
				.log().all()
				.statusCode(200)
				.header("Server", Matchers.equalTo("GitHub.co"))
				.body("name", Matchers.equalTo("repo_pk_restassured"),
				"owner.login", Matchers.comparesEqualTo("orgpawanapivalidation"),
				"private", Matchers.equalTo(false));
	}

}
