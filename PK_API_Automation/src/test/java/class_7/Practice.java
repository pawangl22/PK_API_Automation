package class_7;

import java.util.List;
import java.util.regex.Matcher;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Practice {

	public static void main(String[] args) {


		String url = "https://api.github.com/orgs/{orgName}/repos";
		
		RestAssured
							.given()
								.pathParam("orgName", "orgvanitha")
								.queryParam("per_page", 2)
								.queryParam("page", 1)
							.when()
								.log().all()
								.get(url)
							.then()
								.log().body()
								.statusCode(200)
								.body("id", Matchers.contains(539591977, 539592156),
								"full_name", Matchers.contains("orgvanitha/repo_sep_19_pub4","orgvanitha/repo_sep_19_private2"),
								"owner.login[0]", Matchers.equalTo("orgvanitha"),
								"permissions[0]", Matchers.hasKey("admin"));
	}

}
