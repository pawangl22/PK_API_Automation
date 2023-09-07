package class_4;

import java.lang.reflect.Array;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PracticeResBody {

	public static void main(String[] args) {

		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		JsonPath jPath = res.jsonPath();
		
		List<Object> fn = jPath.getList("data.first_name");
		System.out.println(fn);
		System.out.println(fn.size());
		
		List<Array> email = jPath.get("data.email");
		System.out.println(email);
		System.out.println(email.size());
	}

}
