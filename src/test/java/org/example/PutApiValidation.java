package org.example;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class PutApiValidation extends BaseTest {

    private String url ="https://jsonplaceholder.typicode.com/posts/1";
    private  String payload="{\"id\":1,\"title\":\"abc\",\"body\":\"xyz\",\"userId\":1}";

    @Test
    public void putApiSchemaValidation(){
        Response response = setup.putApi(url,payload);
        assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("put_resource.json"));
    }

    @Test
    public void putApiStatusCodeValidator(){
        Response response = setup.putApi(url,payload);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void putApiDataValidation(){
        Response response = setup.putApi(url,payload);
        Assert.assertEquals(response.jsonPath().getInt("id"),1);

    }
}
