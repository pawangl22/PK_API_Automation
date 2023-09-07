package class_6;

import java.sql.Array;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GitHubExtractResponseBodyJson {

	public static void main(String[] args) {
		
		String url = "https://api.github.com/orgs/{orgName}/repos";
		
		JsonPath jPath = RestAssured
							.given()
								.queryParam("per_page", 2)
								.queryParam("page", 3)
								.queryParam("type", "public")
								.pathParam("orgName", "orgvanitha")
							.when()
								.log().all()
								.get(url)
							.then()
								.log().body()
								.statusCode(200)
								.extract().jsonPath();
	
		String name = jPath.get("name[0]");
		System.out.println(name);
		
		List<Object> nameList = jPath.getList("name");
		System.out.println(nameList);
		}
	}
