package class_12;

import java.sql.Array;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GitHubListRepoTest {

	public static void main(String[] args) {
		
		String url = "https://api.github.com/orgs/{orgName}/repos";
		
					GitHubListRepoRootPOJO res = RestAssured
							.given()
								.pathParam("orgName", "orgvanitha")
							.when()
								.log().all()
								.get(url)
							.then()
								.log().body()
								.statusCode(200)
								.extract().as(GitHubListRepoRootPOJO.class);
	
				String name  = res.getFull_name();
				System.out.println(name);
				}
	}
