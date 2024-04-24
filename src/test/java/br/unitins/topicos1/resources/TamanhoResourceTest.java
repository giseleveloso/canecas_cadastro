package br.unitins.topicos1.resources;

import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.MediaType;

import br.unitins.topicos1.dto.TamanhoDTO;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.hasItem;

@QuarkusTest
public class TamanhoResourceTest {
    @Test
    public void createTest(){
        TamanhoDTO dto = new TamanhoDTO(60.0f, 70.0f,80.0f);
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/tamanhos")
        .then()
        .statusCode(201)
        .body("largura", is(60.0f));
    }
    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/tamanhos")
        .then()
        .statusCode(200)
        .body("largura", hasItem(is(10.0f)));;
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/tamanhos/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    public void updateTest(){
        TamanhoDTO dto = new TamanhoDTO(22.0f, 33.0f,44.0f);
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/tamanhos/1")
        .then()
        .statusCode(204);
    }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 3)
        .delete("/tamanhos/{id}")
        .then()
        .statusCode(204);
    }


   
}
