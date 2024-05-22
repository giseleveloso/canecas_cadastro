package br.unitins.topicos1.resource;


import br.unitins.topicos1.dto.TamanhoDTO;
import br.unitins.topicos1.service.TamanhoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/tamanhos")
public class TamanhoResource {
    
    @Inject
    public TamanhoService tamanhoService;

    @GET

    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(tamanhoService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(tamanhoService.findAll()).build();
    }


    @POST
    @RolesAllowed("Funcionario")
    public Response create(TamanhoDTO dto) {
        return Response.status(Status.CREATED).entity(tamanhoService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("Funcionario")
    public Response update(@PathParam("id") Long id, TamanhoDTO dto) {
        tamanhoService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("Funcionario")
    public Response delete(@PathParam("id") Long id) {
        tamanhoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


}
