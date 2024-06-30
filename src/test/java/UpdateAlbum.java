import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.testng.Assert;

public class UpdateAlbum {

    String baseUrl = "http://localhost:8081/api";
    String token ="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiaWF0IjoxNzE5NzYxNDM5LCJleHAiOjE3MTk3NjUwMzl9.h6OljTK-0JMysvpGXNfacDtM_xfzQjprQ7nND0xq-mAcLGGGgucJkZcXc7TPV2arFGt-CCOrpbKD5klm7mR2qw";


    JSONObject requestBody;

    @Test
    public void testUpdateAlbum(){
            String endpoint = baseUrl+"/albums/";
            requestBody = new JSONObject();
            requestBody.put("title", "gateng ganteng serigala vol 2");
            requestBody.put("description", "Album Update");

            RequestSpecification request = RestAssured.given();
            request.header("Authorization", "Bearer " + token);
            request.header("Content-Type", "application/json");
            request.body(requestBody.toJSONString());

            Response response = request.post(endpoint);
            Assert.assertEquals(response.getStatusCode(), 200);

            String title = response.getBody().jsonPath().getString("title");
            Assert.assertEquals(title,"Update Album");
        }

    }

