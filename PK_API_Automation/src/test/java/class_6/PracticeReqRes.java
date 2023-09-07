package class_6;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class PracticeReqRes {

	public static void main(String[] args) {
		
		String url = "https://reqres.in/api/{user}";
		
		JsonPath res = RestAssured
			.given()
				.queryParam("page", "2")
				.pathParam("user", "users")
			.when()
				.log().all()
				.get(url)
			.then()
				.log().all()
				.statusCode(200)
				.extract().jsonPath();
		
		int page = res.get("page");
		int perPage = res.getInt("per_page");
		
		List<Object> data = res.getList("data");
		List<Integer> idList = res.getList("data.id");
		List<String> nameList = res.getList("data.first_name");
		
		String surl = res.getString("support.url");
		
		System.out.println(page);
		System.out.println(perPage);
		System.out.println(data);
		System.out.println(idList);
		System.out.println(nameList);
		System.out.println(surl);
		
	}

}
