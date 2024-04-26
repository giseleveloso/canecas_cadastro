package br.unitins.topicos1.resource;


import br.unitins.topicos1.dto.CanecaDTO;
import br.unitins.topicos1.service.CanecaService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
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
@Path("/canecas")
public class CanecaResource {
    
    @Inject
    public CanecaService canecaService;

    @GET

    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(canecaService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(canecaService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(canecaService.findByNome(nome)).build();
    }

    @POST
    public Response create(@Valid CanecaDTO dto) {
        return Response.status(Status.CREATED).entity(canecaService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CanecaDTO dto) {
        canecaService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        canecaService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


}
