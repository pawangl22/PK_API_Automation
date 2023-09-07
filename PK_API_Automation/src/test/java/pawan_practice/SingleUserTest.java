package pawan_practice;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class SingleUserTest {

	public static void main(String[] args) {
	
		String url = "https://reqres.in/api/users/{userID}";
		
		SingleUserRootPOJO res = RestAssured
			.given()
				.pathParam("userID", 2)
			.when()
				.log().all()
				.get(url)
			.then()
				.log().all()
				.and().assertThat()
					.statusCode(200)
					.extract().as(SingleUserRootPOJO.class);
		
		int id = res.getData().getId();
		String email = res.getData().getEmail();
		String avatar = res.getData().getAvatar();
		String fn = res.getData().getFirst_name();
		String text = res.getSupport().getText();
		
		MatcherAssert.assertThat(id, Matchers.equalTo(2));
		MatcherAssert.assertThat(email, Matchers.equalTo("janet.weaver@reqres.in"));
		MatcherAssert.assertThat(avatar, Matchers.equalTo("https://reqres.in/img/faces/2-image.jpg"));
		MatcherAssert.assertThat(fn, Matchers.equalTo("Janet"));
		MatcherAssert.assertThat(text, Matchers.containsString("To keep ReqRes free"));
	}

}
