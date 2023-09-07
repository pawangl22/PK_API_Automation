package class_3;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Practice1ExtractResHeaderStatus {

	public static void main(String[] args) {
		
	Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		res.prettyPeek();
		
		System.out.println("\n --------- Printing Headers --------- \n");
		
		Headers completeHeader = res.getHeaders();
		System.out.println(completeHeader);
		
		System.out.println("\n --------- Printing signle Header value --------- \n");
		String connection = res.header("Connection");
		System.out.println(connection);
		
		System.out.println("\n --------- Printing Status code --------- \n");
		int sCode1 = res.statusCode();
		String sCode2 = res.statusLine();
		int sCode3 = res.getStatusCode();
		
		System.out.println(sCode1);
		System.out.println(sCode2);
		System.out.println(sCode3);
	
		System.out.println("\n --------- Printing individual response body --------- \n");
		JsonPath jPath = res.jsonPath();
		
		int page = jPath.get("page");
		System.out.println(page);
		
		int id = jPath.get("data.id[1]");
		System.out.println(id);
		
		System.out.println("\n --------- Printing first_name from response body --------- \n");
		
		String fn = jPath.get("data.first_name[0]");
		System.out.println(fn);
	}
}
