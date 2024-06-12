package br.unitins.topicos1.resource;


import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.topicos1.dto.CanecaDTO;
import br.unitins.topicos1.form.ImageForm;
import br.unitins.topicos1.service.CanecaFileServiceImpl;
import br.unitins.topicos1.service.CanecaService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/canecas")
public class CanecaResource {
    
    @Inject
    public CanecaService canecaService;
    
    @Inject
    public CanecaFileServiceImpl fileService;

    private static final Logger LOG = Logger.getLogger(EnderecoResource.class);


    @GET

    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Executando o metodo findById. Id: %s", id.toString());
        return Response.ok(canecaService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        LOG.info("Executando o findAll");
        return Response.ok(canecaService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.info("Executando o metodo findBynome");
        return Response.ok(canecaService.findByNome(nome)).build();
    }

    @POST
    public Response create(@Valid CanecaDTO dto) {
        LOG.info("Criando uma nova caneca");
        try {
            LOG.infof("Caneca criada com sucesso. Nome: %d", dto.nome());
            return Response.status(Status.CREATED).entity(canecaService.create(dto)).build();
         }  catch (Exception e) {
        LOG.error("Erro ao criar caneca", e);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CanecaDTO dto) {
        LOG.debugf("DTO Atualizado: %s", dto);
        canecaService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Deletando caneca. Id: %s", id.toString());
        canecaService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("/{id}/image/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(@PathParam("id") Long id, @MultipartForm ImageForm form) {
        LOG.info("Fazendo upload de imagem");
        fileService.salvar(id, form.getNomeImagem(), form.getImagem());
        return Response.noContent().build();
    }

    @GET
    @Path("/image/download/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        LOG.info("Fazendo download de imagem");
        ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
        response.header("Content-Disposition", "attachment;filename=" + nomeImagem);
        return response.build();
    }   



}
