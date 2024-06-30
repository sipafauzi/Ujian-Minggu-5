import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.testng.Assert;

public class UserProfile {


    String baseUrl = "http://localhost:8081/api";
    String token ="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiaWF0IjoxNzE5NzU1OTUyLCJleHAiOjE3MTk3NTk1NTJ9.FbnqC7YUXHZps0zbd0asSARGAMkNMQsKVWeN__BfN2Dvfd4Tf4Q_GDLlYUI4u9Uvk-J9WFhy0xEKCDQWeCIAVQ";

    @Test
    public void testUserProfile(){
            String endpoint = baseUrl+"/users/me";

            RequestSpecification requestBody = RestAssured.given();
            requestBody.header("Authorization", "Bearer " + token);
            requestBody.header("Content-Type", "application/json");


            Response response = requestBody.get(endpoint);
            Assert.assertEquals(response.getStatusCode(), 200);

            String id = response.getBody().jsonPath().getString("id");
            String UserName = response.getBody().jsonPath().getString("username");
            String firstName = response.getBody().jsonPath().getString("firstName");
            String lastName = response.getBody().jsonPath().getString("lastName");
            Assert.assertEquals(id, "2");
            Assert.assertEquals(UserName, "sipafauzi");
            Assert.assertEquals(firstName, "sipa");
            Assert.assertEquals(lastName, "fauzi");

        }
    }

