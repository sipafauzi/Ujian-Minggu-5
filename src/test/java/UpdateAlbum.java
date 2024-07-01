import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.testng.Assert;

public class UpdateAlbum {

    String baseUrl = "http://localhost:8081/api";
    String token ="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNzE5ODQ3NjA4LCJleHAiOjE3MTk4NTEyMDh9.zQL-o4jxpNMp_Hxx1mu-J9Lr-_QP6XQxevvhbZ1kvgeJyHraA_YbR0Zb3iVI51Tm9dCtaOsTc3ULNkQXke7Jrw";


    JSONObject requestBody;

    @Test
    public void testUpdateAlbum(){
        String endpoint = baseUrl + "/albums/13";

        requestBody = new JSONObject();
        requestBody.put("title", "New Album");
        requestBody.put("description", "ini adalah album fauzi yang telah di update");

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token);
        request.header("Content-Type", "application/json");
        request.body(requestBody.toJSONString());

        Response response = request.get(endpoint);
        Assert.assertEquals(response.getStatusCode(), 200);

        String title = response.getBody().jsonPath().getString("title");
        Assert.assertEquals(title, "New Album");
        }
    }

