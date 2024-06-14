package br.unitins.topicos1.resource;


import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.FornecedorDTO;
import br.unitins.topicos1.service.FornecedorService;
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
@Path("/fornecedors")
public class FornecedorResource {
    
    @Inject
    public FornecedorService fornecedorService;
    private static final Logger LOG = Logger.getLogger(EnderecoResource.class);

    @GET
    @RolesAllowed("Funcionario")
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o metodo findById. Id: %s", id.toString());
        return Response.ok(fornecedorService.findById(id)).build();
    }

    @GET
    @RolesAllowed("Funcionario")
    public Response findAll() {
        LOG.info("Executando o findAll");
        return Response.ok(fornecedorService.findAll()).build();
    }

    @GET
    @RolesAllowed("Funcionario")
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.info("Executando o metodo findBynome");
        return Response.ok(fornecedorService.findByNome(nome)).build();
    }

    @POST
    @RolesAllowed("Funcionario")
    public Response create(@Valid FornecedorDTO dto) {
        LOG.info("Criando um novo fornecedor");
        try {
            LOG.infof("Fornecedor criado com sucesso. Nome: %d", dto.nome());
            return Response.status(Status.CREATED).entity(fornecedorService.create(dto)).build();
         }  catch (Exception e) {
        LOG.error("Erro ao criar fornecedor", e);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }
    }

    @PUT
    @RolesAllowed("Funcionario")
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, FornecedorDTO dto) {
        LOG.debugf("DTO Atualizado: %s", dto);
        fornecedorService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @RolesAllowed("Funcionario")
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Deletando fornecedor. Id: %s", id.toString());
        fornecedorService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


}
