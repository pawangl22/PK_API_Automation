package class_3;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ReqResPrintHeaders {

	public static void main(String[] args) {
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		Headers header = res.getHeaders();
		System.out.println(header);
		
		System.out.println(res.header("Age"));
		
		System.out.println(res.header("ontent-Type"));

	}

}
