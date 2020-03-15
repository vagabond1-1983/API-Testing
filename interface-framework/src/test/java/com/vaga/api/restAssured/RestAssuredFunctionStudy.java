package com.vaga.api.restAssured;

import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;


/**
 * @author vaga
 * @version 2020/3/14 9:53 下午
 * @description rest assured功能探索
 */
public class RestAssuredFunctionStudy {

    // 基础get请求
    @Test
    public void getUsersTest() {

        Map<String, String> params = new HashMap<String, String>();
        params.put("pageNum", "1");
        params.put("pageSize", "10");
        given()
                .when()
                .baseUri("http://www.sosoapi.com")
                .get("/demo/swagger/user/simple/list.htm")
                .then()
                .log().all(true)
                .body("userId", hasItems(1, 2));
    }

    // json schema validate
    // json schema生成工具：https://jsonschema.net/home
    @Test
    public void jsonSchemaValidateTest() {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.byDefault();
        given()
                .when()
                .baseUri("http://www.sosoapi.com")
                .get("/demo/swagger/user/simple/list.htm")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("user-list-schema.json"));
    }


}
