package class_2;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Practice1 {

	public static void main(String[] args) {

		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(res.asPrettyString());
		res.prettyPrint();
	}

}
