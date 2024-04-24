package br.unitins.topicos1.resources;

import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.MediaType;

import br.unitins.topicos1.dto.TelefoneDTO;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.hasItem;

@QuarkusTest
public class TelefoneResourceTest {
    @Test
    public void createTest(){
        TelefoneDTO dto = new TelefoneDTO("63", "999999999");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/telefones")
        .then()
        .statusCode(201)
        .body("codigoArea", is("63"));
    }
    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/telefones")
        .then()
        .statusCode(200)
        .body("codigoArea", hasItem(is("61")));;
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/telefones/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    public void updateTest(){
        TelefoneDTO dto = new TelefoneDTO("62", "111111111");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/telefones/1")
        .then()
        .statusCode(204);
    }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 3)
        .delete("/telefones/{id}")
        .then()
        .statusCode(204);
    }
    
}
