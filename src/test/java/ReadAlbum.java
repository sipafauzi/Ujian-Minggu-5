import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.testng.Assert;

public class ReadAlbum {

    String baseUrl = "http://localhost:8081/api";


    String token ="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiaWF0IjoxNzE5ODQ1Mzk5LCJleHAiOjE3MTk4NDg5OTl9.2VWw2SjmPR0gFx6yjHpJxIvbsbA29LyoB1DGwAAbHhhYXbwLcx8JTdib4xtAvFDHdEPVASDXMoNPJAKuL1hikA";

    @Test
    public void testRead(){
        String endpoint = baseUrl+"/albums/12";

        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token);
        request.header("Content-Type", "application/json");

        Response response = request.get(endpoint);
        Assert.assertEquals(response.getStatusCode(), 200);

        String title = response.getBody().jsonPath().getString("title");
        Assert.assertEquals(title, "gateng ganteng serigala");
    }
}
