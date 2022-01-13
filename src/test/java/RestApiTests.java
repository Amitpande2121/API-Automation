import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestApiTests {
    @Test
    public void AddPlaceInMaps(){



        RestAssured.baseURI = "https://rahulshettyacademy.com";
      String responce=  given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(Payload.Addplace()).when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("Server","Apache/2.4.18 (Ubuntu)").extract().response().asString();
        System.out.println(responce);
        JsonPath js =new JsonPath(responce);
       String Placeid= js.getString("place_id");
        System.out.println(Placeid);

    }
}
