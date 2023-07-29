package ru.netology.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class API {

    public static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static String PaymentStatus(DataHelper.CardInfo cardInfo) {
        return given()
                .spec(requestSpecification)
                .body(cardInfo)
                .when()
                .post("/api/v1/pay")
                .then()
                .extract().response().asString();
    }

    public static String CreditStatus(DataHelper.CardInfo cardInfo){
        return given()
                .spec(requestSpecification)
                .body(cardInfo)
                .when()
                .post("/api/v1/credit")
                .then()
                .extract().response().asString();
    }
}