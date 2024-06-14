package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;
import br.unitins.topicos1.dto.EnderecoDTO;
import br.unitins.topicos1.service.EnderecoService;
import jakarta.annotation.security.RolesAllowed;
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
@Path("/enderecos")
public class EnderecoResource {
    
    @Inject
    public EnderecoService enderecoService;
    private static final Logger LOG = Logger.getLogger(EnderecoResource.class);

    @GET
    @RolesAllowed("Funcionario")
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        LOG.info("Executando o findById");
        LOG.infof("Executando o metodo findById. Id: %s", id.toString());
        return Response.ok(enderecoService.findById(id)).build();
    }

    @GET
    @RolesAllowed("Funcionario")
    public Response findAll() {
        LOG.info("Executando o findAll");
        return Response.ok(enderecoService.findAll()).build();
    }

    @POST
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response create(@Valid EnderecoDTO dto) {
    LOG.info("Criando um novo endereço");
    try {
        LOG.infof("Endereço criado com sucesso. CEP: %d", dto.cep());
        return Response.status(Status.CREATED).entity(enderecoService.create(dto)).build();
    } catch (Exception e) {
        LOG.error("Erro ao criar endereço", e);
        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }
}
/* 
    @POST
    public Response create(@Valid EnderecoDTO dto) {
        LOG.info("INFO");
        LOG.warn("WARN");
        LOG.error("ERROR");
        LOG.fatal("FATAL");
        LOG.trace("TRACE");
        LOG.debugf("DTO: %s", dto);
        return Response.status(Status.CREATED).entity(enderecoService.create(dto)).build();
    }
    */

    @PUT
    @RolesAllowed({"Funcionario", "Cliente"})
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, EnderecoDTO dto) {
        LOG.debugf("DTO Atualizado: %s", dto);
        enderecoService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @RolesAllowed({"Funcionario", "Cliente"})
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Deletando endereço. Id: %s", id.toString());
        enderecoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


}
