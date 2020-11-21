package org.example;

import io.restassured.response.Response;
import org.example.base.Setup;
import org.example.pojo.ResponseResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetApiValidate extends BaseTest {

    private String url = "https://jsonplaceholder.typicode.com/posts";

    @Test
    public void getApiTestSchemaValidator(){

        Response response = setup.getApi(url);
        assertThat(response.getBody().asString(),matchesJsonSchemaInClasspath("all_resource.json"));
    }
    @Test
    public void getApiTestStatusCodeValidator(){

        Response response = setup.getApi(url);
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test
    public void getApiTestListCountValidation(){

        Response response = setup.getApi(url);
        //assertThat(response.jsonPath().getList("$", ResponseResult.class),is(gr));
        Assert.assertTrue(response.jsonPath().getList("$", ResponseResult.class).size()>=100);
    }
}
