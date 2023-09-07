package class_4;

import java.sql.Array;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReqResJsonArraySize {

	public static void main(String[] args) {
		Response req = RestAssured.get("https://reqres.in/api/users?page=2");
		req.prettyPrint();
		
		JsonPath jpath = req.jsonPath();
		
		int dataCount = jpath.get("data.size()");
		System.out.println(dataCount);
		
		int supportCount = jpath.get("support.size()");
		System.out.println(supportCount);
		
		int count = jpath.get("size()");
		System.out.println(count);
		
		List<Array> firstName = jpath.getList("data.first_name");
		System.out.println(firstName);
		System.out.println(firstName.size());
	}

}
