package com.selecao.web.service;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
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

import com.selecao.ejb.facade.FacadeLocal;

@Path("/cep")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CepResource {

    @EJB
    FacadeLocal facade;
    
    @GET
    public Response listarCep(@DefaultValue("1") @QueryParam("draw") Integer draw,
		@DefaultValue("0") @QueryParam("start") Integer startPosition,
		@DefaultValue("10") @QueryParam("length") Integer maxResult) {
	return Response.status(Status.NO_CONTENT).build();
    }
    
    @GET
    @Path("/{id}")
    public Response pegarCep(@PathParam("id") Long id) {
	return Response.status(Status.NO_CONTENT).build();
    }
    
    @POST
    public Response salvarCep() {
	return Response.status(Status.NO_CONTENT).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response mergeCep(@PathParam("id") Long id) {
	return Response.status(Status.NO_CONTENT).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deletarCep(@PathParam("id") Long id) {
	return Response.status(Status.NO_CONTENT).build();
    }
}

