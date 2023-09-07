package class_10;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ReqResUpdateUserTest {

	public static void main(String[] args) {
		
		String url = "https://reqres.in/api/users/2";
		
		ReqResUpdateUserRequestPOJO obj = new ReqResUpdateUserRequestPOJO();
		obj.setName("Vanitha");
		obj.setJob("Automation Lead");
		
		ReqResUpdateUserResponsePOJO res = RestAssured
			.given()
				.body(obj)
				.contentType(ContentType.JSON)
			.when()
				.log().all()
				.patch(url)
			.then()
				.log().all()
				.and().assertThat()
					.statusCode(200)
					.extract().as(ReqResUpdateUserResponsePOJO.class);
		
		String name = res.getName();
		String job = res.getJob();
		String updateAt = res.getUpdatedAt();
		
		MatcherAssert.assertThat(name, Matchers.equalTo("Vanitha"));
		MatcherAssert.assertThat(job, Matchers.equalTo("Automation Lead"));
		
		System.out.println(updateAt);

	}

}
