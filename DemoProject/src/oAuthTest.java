import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import files.ReUsableMethods;
import files.payload;


public class oAuthTest {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\satya\\OneDrive\\Desktop\\Api Testing Rest Assured\\DemoProject\\Drivers\\gechodriver\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\satya\\OneDrive\\Desktop\\Api Testing Rest Assured\\DemoProject\\Drivers\\ChromeDriver\\chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWhIvetshYVrWX6m763IvcFCYLbBmtDkk3U31RmjAW332nQMs8_gj823ReikVHEzvA&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none");
		String url = driver.getCurrentUrl();

		String partialCode = url.split("code=")[1];
		String code = partialCode.split("&scope")[0];
		System.out.println(code);
		
		String accessTokenResponse = given().queryParams("code",code).urlEncodingEnabled(false)
		.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code")
		.when()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();	
		
		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");
		
		
		String response = given().queryParam("access_token", accessToken)
				.when()
				.get("https://rahulshettyacademy.com/getCourse.php").asString();
		System.out.println(response);
	}

}
