  import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.ReUsableMethods;
import files.payload;

	import files.ReUsableMethods;
	import files.payload;

	public class EncodeApi {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
	// validate if Add Place API is workimg as expected 
			//Add place-> Update Place with New Address -> Get Place to validate if New address is present in response
			
			//given - all input details 
			//when - Submit the API -resource,http method
			//Then - validate the response
			RestAssured.baseURI= "https://reqres.in/api/users";
			String response=given().log().all().header("Content-Type","application/json")
			.body("{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"leader\"\r\n"
					+ "}").when().post()
		.then().assertThat().statusCode(201).extract().response().asString();
			//.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
			
			System.out.println(response);
			

	}

	}

