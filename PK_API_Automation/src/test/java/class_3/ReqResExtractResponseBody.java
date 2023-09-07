package class_3;

import java.util.ArrayList;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReqResExtractResponseBody {

	public static void main(String[] args) {
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		
		res.prettyPrint();
		JsonPath jPath = res.jsonPath();
		//String page = jpath.get("page");
		//String fn = jpath.get("data.id");
		 String fn = jPath.get("data.first_name");
		
		//System.out.println(page);
		//System.out.println(fn);
		System.out.println(fn);

	}

}
