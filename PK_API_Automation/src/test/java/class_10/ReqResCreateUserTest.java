package class_10;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ReqResCreateUserTest {

	public static void main(String[] args) {
		
		String url = "https://reqres.in/api/users";
		
		ReqResCreateUserPOJO obj = new ReqResCreateUserPOJO();
		obj.setName("Pawan");
		obj.setJob("Technical Lead");
		
		ReqResCreateUserPOJO res = RestAssured
					.given()
						.body(obj)
						.contentType(ContentType.JSON)
					.when()
						.log().all()
						.post(url)
					.then()
						.log().all()
						.and().assertThat()
							.statusCode(201)
							.extract().as(ReqResCreateUserPOJO.class);
			
		String name = res.getName();
		String id = res.getId();
		String job = res.getJob();
		String createdAt = res.getCreatedAt();
		
		MatcherAssert.assertThat(name, Matchers.equalToIgnoringCase("pawan"));
		MatcherAssert.assertThat(job, Matchers.equalTo("Technical Lead"));
		
		System.out.println(id);
		System.out.println(createdAt);
		
			
	}

}
