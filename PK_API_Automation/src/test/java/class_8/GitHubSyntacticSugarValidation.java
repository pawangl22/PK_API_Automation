package class_8;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class GitHubSyntacticSugarValidation {

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
				.and().assertThat()
					.statusCode(200)
				.and().assertThat()
					.header("Server", Matchers.equalTo("GitHub.com"))
				.and().assertThat()
					.body("name", Matchers.equalTo("repo_pk_restassured"),
					"owner.login", Matchers.comparesEqualTo("orgpawanapivalidation"),
					"private", Matchers.equalTo(false));
	}

}
