package class_6;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Practice {

	public static void main(String[] args) {
		
		String url = "https://reqres.in/api/{user}";
		JsonPath jPath = RestAssured
							.given()
								.queryParam("delay", 3)
								.pathParam("user", "users")
							.when()
								.log().all()
								.get(url)
							.then()
								.log().body()
								.statusCode(200)
								.extract().jsonPath();
		String sUrl = jPath.get("support.url");
		System.out.println(sUrl);
		
		List<String> idList = jPath.getList("data.id");
		System.out.println(idList);
		System.out.println(idList.size());
		
		String emailList = jPath.getString("data.email[0]");
		System.out.println(emailList);
		
		String fn = jPath.getString("data[5].first_name");
		System.out.println(fn);
		
		int count = jPath.get("size()");
		System.out.println(count);
		
		int perPage = jPath.getInt("per_page");
		System.out.println(perPage);
		
		List<Object> dataList = jPath.getList("data");
		System.out.println(dataList);
		System.out.println(dataList.size());
	}

}
