package class_3;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReqResPrintStatusCode {

	public static void main(String[] args) {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		int statusCode = res.statusCode();
		System.out.println(statusCode);
		
		String status = res.statusLine();
		System.out.println(status);
		
		int statusCode2 = res.statusCode();
		System.out.println(statusCode2);
	}

}
