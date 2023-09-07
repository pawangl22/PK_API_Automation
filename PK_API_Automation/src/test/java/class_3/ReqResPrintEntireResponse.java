package class_3;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReqResPrintEntireResponse {

	public static void main(String[] args) {

		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		res.prettyPeek();

	}

}
