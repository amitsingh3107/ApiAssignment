package org.example;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetApiwithSpecificResouceValidate extends BaseTest {
  private String url ="https://jsonplaceholder.typicode.com/posts/1";
    @Test
    public void getApiSingleResouceScemaValidation(){

        Response response = setup.getApi(url);
        assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("single_resource.json"));
    }

    @Test
    public void getApiSingleResourceStausCodeValidation(){

        Response response = setup.getApi(url);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void getApiSingleResourceSizeValidation(){

    }

    @Test
    public void getApiSingleResourceBodyValidation(){
        Response response = setup.getApi(url);
        Assert.assertEquals(response.jsonPath().getInt("id"),1);
    }
}
