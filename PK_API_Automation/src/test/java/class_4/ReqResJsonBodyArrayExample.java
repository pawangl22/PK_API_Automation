package class_4;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReqResJsonBodyArrayExample {

	public static void main(String[] args) {
		Response req = RestAssured.get("https://reqres.in/api/users?page=2");
		req.prettyPrint();
		JsonPath jpath = req.jsonPath();

		String email = jpath.getString("data[0].email");
		System.out.println(email);

		int id = jpath.getInt("data[2].id");
		System.out.println(id);
	}

}
