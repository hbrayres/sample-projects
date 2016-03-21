package br.com.hbrayres.angular.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import br.com.hbrayres.angular.facade.IFacadeLocal;
import br.com.hbrayres.angular.model.Cliente;

/**
 * 
 */
@Stateless
@Path("/clientes")
public class ClienteEndpoint {

    @EJB
    private IFacadeLocal facade;

    @POST
    @Consumes("application/json")
    public Response create(Cliente entity) {

	facade.persist(entity);

	return Response
		.created(UriBuilder.fromResource(ClienteEndpoint.class).path(String.valueOf(entity.getId())).build())
		.build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteById(@PathParam("id") Long id) {
	try {
	    facade.deleteEnderecoById(id);
	} catch (NoResultException e) {
	    return Response.status(Status.NOT_FOUND).build();
	}

	return Response.noContent().build();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public Response findById(@PathParam("id") Long id) {
	final Cliente entity = facade.getClienteById(id);
	if (entity == null) {
	    return Response.status(Status.NOT_FOUND).build();
	}
	return Response.ok(entity).build();
    }

    @GET
    @Produces("application/json")
    public List<Cliente> listAll(@QueryParam("start") Integer startPosition, @QueryParam("max") Integer maxResult) {
	final List<Cliente> results = facade.listAllCliente(startPosition, maxResult);
	return results;
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes("application/json")
    public Response update(@PathParam("id") Long id, Cliente entity) {
	if (entity == null) {
	    return Response.status(Status.BAD_REQUEST).build();
	}
	if (id == null) {
	    return Response.status(Status.BAD_REQUEST).build();
	}
	if (!id.equals(entity.getId())) {
	    return Response.status(Status.CONFLICT).entity(entity).build();
	}
	try {

	    entity = facade.persist(entity);

	} catch (NoResultException e) {
	    return Response.status(Status.NOT_FOUND).build();
	} catch (OptimisticLockException e) {
	    return Response.status(Response.Status.CONFLICT).entity(e.getEntity()).build();
	}

	return Response.noContent().build();
    }
}
