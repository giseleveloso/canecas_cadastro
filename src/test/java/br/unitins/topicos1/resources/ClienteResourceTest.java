package br.unitins.topicos1.resources;

import org.junit.jupiter.api.Test;

import jakarta.ws.rs.core.MediaType;

import br.unitins.topicos1.dto.ClienteDTO;
import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.hasItem;

@QuarkusTest
public class ClienteResourceTest {
    @Test
    public void createTest(){
        ClienteDTO dto = new ClienteDTO("Teresa",5L,5L,"teresa@gmail.com");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .post("/clientes")
        .then()
        .statusCode(201)
        .body("nome", is("Teresa"));
    }

    @Test
    public void findByIdTest(){
        given()
        .when()
        .get("/clientes/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    public void findByNomeTest(){
        given()
        .when()
        .get("/clientes/1")
        .then()
        .statusCode(200)
        .body("nome", is("Giovanna"));
    }

    @Test
    public void updateTest(){
        ClienteDTO dto = new ClienteDTO("Mário",4L,4L,"leandra@gmail.com");
        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .put("/clientes/2")
        .then()
        .statusCode(204);
    }

    @Test
    public void findAllTest(){
        given()
        .when()
        .get("/clientes")
        .then()
        .statusCode(200)
        .body("nome", hasItem(is("Mário")));;
    }

    @Test
    public void deleteTest(){
        given()
        .when()
        .pathParam("id", 3)
        .delete("/clientes/{id}")
        .then()
        .statusCode(204);
    }
    
}
