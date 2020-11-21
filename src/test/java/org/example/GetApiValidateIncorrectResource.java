package org.example;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetApiValidateIncorrectResource extends BaseTest{
    String url ="https://jsonplaceholder.typicode.com/invalidposts";

    @Test
    public void getApiInvalidResourceSatusCodeValidation(){
        Response response = setup.getApi(url);
        Assert.assertEquals(response.statusCode(),404);
    }
}
