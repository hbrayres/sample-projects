package br.com.hbrayres.angular.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.hbrayres.angular.model.Cliente;

@Stateless
public class ClienteDaoImpl implements IClienteDao {

    @PersistenceContext(unitName = "angular-pu")
    private EntityManager em;

    @Override
    public Cliente persist(final Cliente entity) {
	if (entity.getId() != null) {
	    if (em.find(Cliente.class, entity.getId()) == null) {
		throw new NoResultException();
	    }
	    return em.merge(entity);
	} else {
	    em.persist(entity);
	    return entity;
	}
    }

    @Override
    public void deleteById(final Long id) throws NoResultException {
	final Cliente entity = em.find(Cliente.class, id);
	if (entity == null) {
	    throw new NoResultException();
	}
	em.remove(entity);
    }

    @Override
    public Cliente getById(final Long id) {
	Cliente entity;
	try {
	    entity = em.find(Cliente.class, id);
	} catch (NoResultException nre) {
	    entity = null;
	}
	return entity;
    }

    @Override
    public List<Cliente> listAll(final Integer startResult, final Integer maxResult) {
	final TypedQuery<Cliente> findAllQuery = em.createQuery("SELECT DISTINCT c FROM Cliente c ORDER BY c.id",
		Cliente.class);
	if (startResult != null) {
	    findAllQuery.setFirstResult(startResult);
	}
	if (maxResult != null) {
	    findAllQuery.setMaxResults(maxResult);
	}
	final List<Cliente> results = findAllQuery.getResultList();
	return results;
    }

}
