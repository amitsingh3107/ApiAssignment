package org.example;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletApiValidation extends BaseTest {

    private String url ="https://jsonplaceholder.typicode.com/posts/1";

    @Test
    public void deleteApiStatusCodeValidation(){
        Response response = setup.deleteApi(url);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test
    public void deleteApiDataValidation(){
        Response response = setup.deleteApi(url);
        Assert.assertEquals(response.jsonPath().get("$").toString(),"{}");
    }
}
