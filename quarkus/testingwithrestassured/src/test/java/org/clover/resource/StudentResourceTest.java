package org.clover.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@Tag("Integration")
class StudentResourceTest {

    @Test
    void getStudentList() {
        RestAssured
                .given()
                .when()
                .get("/getstudentlist")
                .then()
                .body("size()", equalTo(4))
                .body("branch", hasItems("CS","EE"));
    }
}