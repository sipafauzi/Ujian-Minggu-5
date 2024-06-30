import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.testng.Assert;

public class DeleteAlbum {

    String baseUrl = "http://localhost:8081/api";

    String token ="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiaWF0IjoxNzE5NzYxNDM5LCJleHAiOjE3MTk3NjUwMzl9.h6OljTK-0JMysvpGXNfacDtM_xfzQjprQ7nND0xq-mAcLGGGgucJkZcXc7TPV2arFGt-CCOrpbKD5klm7mR2qw";
    JSONObject requestBody;


    @Test
    public void testCreateAlbum(){
        String endpoint = baseUrl+"/albums/";
        requestBody = new JSONObject();
        requestBody.put("title", "gateng ganteng serigala");
        requestBody.put("description", "Album Baru");

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token);
        request.header("Content-Type", "application/json");
        request.body(requestBody.toJSONString());

        Response response = request.post(endpoint);
        Assert.assertEquals(response.getStatusCode(), 200);

        String albumId = response.getBody().jsonPath().getString("id");
        Assert.assertNotNull(albumId);
    }

}
