package pawan_practice;

import org.hamcrest.MatcherAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateRepoTest {

	public static void main(String[] args) {

		String url = "https://api.github.com/orgs/{owner}/repos";
		
		CreateRepoPOJO createObj = new CreateRepoPOJO();
		createObj.setName("Pawan_Kumar_repo_1");
		createObj.setPrivateVa(false);
		
		CreateRepoResponsePOJO res = RestAssured
		.given()
			.pathParam("owner", "orgpawanapivalidation")
			.header("Authorization", "Bearer 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")
			.contentType(ContentType.JSON)
			.body(createObj)
		.when()
			.log().all()
			.post(url)
		.then()
			.log().all()
			.and().assertThat()
				.statusCode(201)
				.extract().as(CreateRepoResponsePOJO.class);
		
		String name = res.getName();
		System.out.println(name);
	}

}
