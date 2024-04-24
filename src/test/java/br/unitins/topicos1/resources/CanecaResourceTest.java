package br.unitins.topicos1.resources;

import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.MediaType;

import br.unitins.topicos1.dto.CanecaDTO;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.hasItem;

@QuarkusTest
public class CanecaResourceTest {
    @Test
    public void createTest(){
        CanecaDTO dto = new CanecaDTO("Caneca Interior","Interior nas cores: azul, amarelo e rosa",40.50f,1L,320,1,2L);
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/canecas")
        .then()
        .statusCode(201)
        .body("nome", is("Caneca Interior"));
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/canecas/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    public void findByNomeTest(){
        given()
        .when()
        .get("/canecas/1")
        .then()
        .statusCode(200)
        .body("nome", is("Caneca coração"));
    }


    @Test
    public void updateTest(){
        CanecaDTO dto = new CanecaDTO("Caneca Totalmente Preta","Possui uma tarja branca para sublimação",60f,2L,320,2,1L);
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/canecas/2")
        .then()
        .statusCode(204);
    }

    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/canecas")
        .then()
        .statusCode(200)
        .body("nome", hasItem(is("Caneca coração")));;
    }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 3)
        .delete("/canecas/{id}")
        .then()
        .statusCode(204);
    }
    
}
