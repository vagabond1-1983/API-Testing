package com.vaga.api.restAssured;

import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
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
    private RequestSpecification requestSpecification;
    @BeforeClass
    public void init() {
        requestSpecification = given().when().baseUri("http://www.sosoapi.com");
    }

    // 基础get请求
    @Test
    public void getUsersTest() {
        requestSpecification
                .when()
                .get("/demo/swagger/user/simple/list.htm?pageSize={pageSize}&pageNum={pageNum}",10,1)
                .then()
                .log().all(true)
                .body("userId", hasItems(1, 2));
    }

    // json schema validate
    // json schema生成工具：https://jsonschema.net/home
    @Test
    public void jsonSchemaValidateTest() {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.byDefault();
        requestSpecification
                .when()
                .get("/demo/swagger/user/simple/list.htm")

                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("user-list-schema.json"));
    }

    // userId 动态输入，年龄大于18，email需要符合@的邮箱格式
    @Test
    public void queryUserTest() {
        Long userId = 1L;
        requestSpecification
                .when()
                .get("/demo/swagger/user/simple/{userId}/info.htm", userId)
                .then()
                .assertThat()
                .body("nickName", notNullValue())
                .body("age", greaterThan(18))
                .body("email", matchesRegex(".+@.+"));

    }


}
