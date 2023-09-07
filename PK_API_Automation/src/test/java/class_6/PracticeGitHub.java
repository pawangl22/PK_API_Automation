package class_6;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PracticeGitHub {
	public static void main(String[] args) {
		
		String url = "https://api.github.com/orgs/{orgName}/repos";
		
		JsonPath res = RestAssured
			.given()
				.pathParam("orgName", "orgvanitha")
				.queryParam("per_page", 2)
				.queryParam("page", 3)
				.queryParam("type", "public")	
			.when()
				.log().all()
				.get(url)
			.then()
				.log().all()
				.statusCode(200)
				.extract().jsonPath();
		
		int id = res.get("id[0]");
		System.out.println(id);
		
		List<String> names = res.getList("name");
		System.out.println(names);
		}

}
