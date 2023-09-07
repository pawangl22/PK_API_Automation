package class_12;

import java.util.ArrayList;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class ReqResListUsersTest {

	public static void main(String[] args) {
		
		
		String url = "https://reqres.in/api/users";
		
		ReqResListUsersRootPOJO res = RestAssured
				.given()
					.queryParam("page", 2)
					
				.when()
					.log().all()
					.get(url)
				.then()
					.log().all()
					.and().assertThat()
						.statusCode(200)
						.extract().as(ReqResListUsersRootPOJO.class);
		
		String sURL = res.getSupport().getUrl();
		MatcherAssert.assertThat(sURL, Matchers.equalTo("https://reqres.in/#support-heading"));
		
		String sText = res.getSupport().getText();
		MatcherAssert.assertThat(sText, Matchers.containsString("To keep ReqRes free, contributions towards server costs are appreciated!"));
		
		String email = res.getData().get(2).getEmail();
		MatcherAssert.assertThat(email, Matchers.equalTo("tobias.funke@reqres.in"));
		System.out.println(email);
		
		ArrayList<ReqResListUsersDataPOJO> data = res.getData();
		for(int i=0; i<=data.size()-1; i++) {
		int id = res.getData().get(i).getId();
		System.out.println(id);
		}
	}

}
