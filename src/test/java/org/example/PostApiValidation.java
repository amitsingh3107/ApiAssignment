package org.example;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class PostApiValidation extends BaseTest {
    private String url = "https://jsonplaceholder.typicode.com/posts";
    private String payload = "{\"title\":\"foo\",\"body\":\"bar\",\"userId\":1}";

    @Test
    public void postApiStatusCodeValidation(){
        Response response = setup.postApi(url,payload);
        Assert.assertEquals(response.statusCode(),201);
    }

    @Test
    public void postApiSchemaValidation(){
        Response response = setup.postApi(url,payload);
        assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("put_resource.json"));
    }

    @Test
    public void postApiDataValidation(){
        Response response = setup.postApi(url,payload);
        Assert.assertNotNull(response.jsonPath().getInt("id"));
    }

}
