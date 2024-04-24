package br.unitins.topicos1.resources;

import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.MediaType;

import br.unitins.topicos1.dto.FornecedorDTO;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.hasItem;

@QuarkusTest
public class FornecedorResourceTest {
    @Test
    public void createTest(){
        FornecedorDTO dto = new FornecedorDTO("Marcela",8L,8L,"teresa@gmail.com");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/fornecedors")
        .then()
        .statusCode(201)
        .body("nome", is("Marcela"));
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/fornecedors/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    public void findByNomeTest(){
        given()
        .when()
        .get("/fornecedors/1")
        .then()
        .statusCode(200)
        .body("nome", is("José"));
    }

    @Test
    public void updateTest(){
        FornecedorDTO dto = new FornecedorDTO("Gisele de Oliveira",7L,7L,"leandra@gmail.com");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/fornecedors/2")
        .then()
        .statusCode(204);
    }

    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/fornecedors")
        .then()
        .statusCode(200)
        .body("nome", hasItem(is("José")));;
    }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 3)
        .delete("/fornecedors/{id}")
        .then()
        .statusCode(204);
    }
    
}
