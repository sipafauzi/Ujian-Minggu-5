import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.testng.Assert;

public class DeleteAlbum {

    String baseUrl = "http://localhost:8081/api";

    String token ="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiaWF0IjoxNzE5ODQ1Mzk5LCJleHAiOjE3MTk4NDg5OTl9.2VWw2SjmPR0gFx6yjHpJxIvbsbA29LyoB1DGwAAbHhhYXbwLcx8JTdib4xtAvFDHdEPVASDXMoNPJAKuL1hikA";
    JSONObject requestBody;


    @Test
    public void testCreateAlbum(){
        String endpoint = baseUrl+"/albums/12";

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token);
        request.header("Content-Type", "application/json");

        Response response = request.delete(endpoint);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());
        Assert.assertTrue(response.getStatusCode() == 200 || response.getStatusCode() == 204);
    }

}
