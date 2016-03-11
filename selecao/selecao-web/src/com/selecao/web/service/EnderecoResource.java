package com.selecao.web.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.selecao.ejb.entity.Endereco;
import com.selecao.ejb.entity.filtro.FiltroEndereco;
import com.selecao.ejb.facade.FacadeLocal;

@Path("/endereco")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnderecoResource {

    @EJB
    private FacadeLocal facade;

    /**
     * Listar os enderecos conforme parametros de pesquisa informados.
     * 
     * @param logradouro
     * @param bairro
     * @param cep
     * @param cidade
     * @param estado
     * @return
     */
    @GET
    public Response listarCep(@QueryParam("logradouro") final String logradouro,
	    @QueryParam("bairro") final String bairro, @QueryParam("cep") final Long cep,
	    @QueryParam("cidade") final String cidade, @QueryParam("estaco") final String estado) {
	try {
	    final FiltroEndereco filtro = new FiltroEndereco();
	    filtro.setLogradouro(logradouro);
	    filtro.setBairro(bairro);
	    filtro.setCep(cep);
	    filtro.setCidade(cidade);
	    filtro.setEstado(estado);

	    final List<Endereco> result = facade.listEndereco(filtro);
	    return Response.ok(result).build();

	} catch (Exception e) {
	    return Response.status(Status.NOT_FOUND).build();
	}
    }

    /**
     * Recuperar o endereco conforme id.
     * 
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    public Response recuperarCep(@PathParam("id") final Long id) {
	try {
	    final Endereco end = facade.getEndereco(id);
	    return Response.ok(end).build();
	    
	} catch (Exception e) {
	    return Response.status(Status.NOT_FOUND).build();
	}
    }

    /**
     * Salvar o respectivo endereco.
     * @param endereco
     * @return
     */
    @POST
    public Response salvarCep(final Endereco endereco) {
	try {
	    facade.saveEndereco(endereco);
	    return Response.ok().build();
	    
	} catch (Exception e) {
	    return Response.status(Status.NOT_ACCEPTABLE).build();
	}
    }

    /**
     * Edita o respectivo endereco.
     * 
     * @param id
     * @param endereco
     * @return
     */
    @PUT
    @Path("/{id}")
    public Response mergeCep(@PathParam("id") final Long id, final Endereco endereco) {
	try {
	    endereco.setId(id);
	    facade.saveEndereco(endereco);
	    return Response.ok().build();
	    
	} catch (Exception e) {
	    return Response.status(Status.NOT_ACCEPTABLE).build();
	}
    }

    /**
     * Deleta o registro conforme o id.
     * 
     * @param id
     * @return
     */
    @DELETE
    @Path("/{id}")
    public Response deletarCep(@PathParam("id") final Long id) {
	try {
	    facade.deleteEndereco(id);
	    return Response.ok().build();
	    
	} catch (Exception e) {
	    return Response.status(Status.NOT_ACCEPTABLE).build();
	}
    }
}
