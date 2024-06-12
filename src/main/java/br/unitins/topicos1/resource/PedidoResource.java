package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.service.PedidoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.PathParam;
    
@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    public PedidoService service;

    @POST
    public Response create(PedidoDTO dto){
        return Response.ok(service.create(dto)).build();
    }

    @PATCH
    @Path("/switchStatus/{id}")
    public Response switchStatus( @PathParam("id") Long id){
        service.switchStatus(id);
        return Response.noContent().build(); 
    }

    @GET
    public Response findAll(){
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("/search/cliente/id/{id}")
    public Response findById( @PathParam("id") Long id){
        return Response.ok(service.findById(id)).build();
    }

    @GET
    public Response findByCliente( @PathParam("idCliente") Long idCliente ){
        return Response.ok(service.findByCliente(idCliente)).build();
    }

}