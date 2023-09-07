package class_11;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class ReqResGetUserTest {

	public static void main(String[] args) {
		String url = "https://reqres.in/api/users/{userID}";
		
		ReqResRootPOJO res = RestAssured
			.given()
				.pathParam("userID", 2)
			.when()
				.log().all()
				.get(url)
			.then()
				.log().all()
				.statusCode(200)
				.extract().as(ReqResRootPOJO.class);
		
		String email = res.getData().getEmail();
		float id = res.getData().getId();
		String fn = res.getData().getFirst_name();
		String ln = res.getData().getLast_name();
		
		System.out.println(email);
		System.out.println(id);
		System.out.println(fn);
		System.out.println(ln);
		
		MatcherAssert.assertThat(email, Matchers.equalTo("janet.weaver@reqres.in"));
		MatcherAssert.assertThat(fn, Matchers.equalTo("Janet"));
		MatcherAssert.assertThat(ln, Matchers.equalTo("Weaver"));

	}

}
