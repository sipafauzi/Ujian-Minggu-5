import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.testng.Assert;

public class CreateAlbum {

    String baseUrl = "http://localhost:8081/api";

    String token ="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiaWF0IjoxNzE5ODQ1Mzk5LCJleHAiOjE3MTk4NDg5OTl9.2VWw2SjmPR0gFx6yjHpJxIvbsbA29LyoB1DGwAAbHhhYXbwLcx8JTdib4xtAvFDHdEPVASDXMoNPJAKuL1hikA";
    JSONObject requestBody;


    @Test
    public void testCreateAlbum(){
        String endpoint = baseUrl+"/albums";
        requestBody = new JSONObject();
        requestBody.put("title", "gateng ganteng serigala 2");
        requestBody.put("description", "Album Baru");

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token);
        request.header("Content-Type", "application/json");
        request.body(requestBody.toJSONString());

        Response response = request.post(endpoint);
        Assert.assertEquals(response.getStatusCode(), 201);

        String albumid = response.getBody().jsonPath().getString("id");
        Assert.assertNotNull(albumid);
    }
}
