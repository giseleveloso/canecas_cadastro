package br.unitins.topicos1.resource;


import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.service.TelefoneService;
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
@Path("/telefones")
public class TelefoneResource {
    
    @Inject
    public TelefoneService telefoneService;

    private static final Logger LOG = Logger.getLogger(EnderecoResource.class);


    @GET

    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o metodo findById. Id: %s", id.toString());
        return Response.ok(telefoneService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        LOG.info("Executando o findAll");
        return Response.ok(telefoneService.findAll()).build();
    }

    @POST
    public Response create(@Valid TelefoneDTO dto) {
        LOG.info("Criando um novo telefone");
        try {
            LOG.infof("Telefone criado com sucesso. Numero: %d", dto.numero());
            return Response.status(Status.CREATED).entity(telefoneService.create(dto)).build();
         }  catch (Exception e) {
        LOG.error("Erro ao criar telefone", e);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, TelefoneDTO dto) {
        LOG.debugf("DTO Atualizado: %s", dto);
        telefoneService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Deletando telefone. Id: %s", id.toString());
        telefoneService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


}
