package class_4;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReqResExtraceResponseBody {

	public static void main(String[] args) {
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		res.prettyPrint();
		
		JsonPath jpath = res.jsonPath();
		String url = jpath.getString("support.url");
		System.out.println(url);
		
		String text = jpath.getString("support.text");
		System.out.println(text);
		
		int id = jpath.getInt("data.id");
		System.out.println(id);
	}

}
