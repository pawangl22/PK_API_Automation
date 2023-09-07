package class_4;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HeaderValidation {

	public static void main(String[] args) {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		res.prettyPeek();
		String actualServer = res.getHeader("Server");
		String expectedServer = "cloudflare";
		
		String actualAge = res.getHeader("Age");
		String expectedAge = "849";
		
		MatcherAssert.assertThat(actualServer, Matchers.equalTo(expectedServer));
		MatcherAssert.assertThat(actualAge, Matchers.equalTo(expectedAge));
	}

}
