package class_2;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestClass {

	public static void main(String[] args) {
		
		Response res = RestAssured.get("https://api-stage.github.com/repos/orgvanitha/repo_sep_19_pub2");
		res.prettyPrint();
	}

}
