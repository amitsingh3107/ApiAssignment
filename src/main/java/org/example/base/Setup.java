package org.example.base;


import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.*;

public class Setup {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    public Response getApi(String url){

        return given().log().all().when().get(url).then().log().all().extract().response();

    }

    public Response postApi(String url, String payLoad){
        return given().body(payLoad).log().all().post(url).then().log().all().extract().response();
    }
    public Response putApi(String url, String payLoad){
        return given().body(payLoad).log().all().put(url).then().log().all().extract().response();
    }
    public Response deleteApi(String url){
        return given().log().all().delete(url).then().log().all().extract().response();
    }
}
