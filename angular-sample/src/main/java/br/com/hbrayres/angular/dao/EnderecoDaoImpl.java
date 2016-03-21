package br.com.hbrayres.angular.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.hbrayres.angular.model.Endereco;

@Stateless
public class EnderecoDaoImpl implements IEnderecoDao {

    @PersistenceContext(unitName = "angular-pu")
    private EntityManager em;

    @Override
    public Endereco persist(Endereco entity) {
	if (entity.getId() != null) {
	    if (em.find(Endereco.class, entity.getId()) == null) {
		throw new NoResultException();
	    }
	    return em.merge(entity);
	} else {

	    em.persist(entity);

	    return entity;
	}
    }

    @Override
    public void deleteById(Long id) throws NoResultException {
	final Endereco entity = em.find(Endereco.class, id);
	if (entity == null) {
	    throw new NoResultException();
	}
	em.remove(entity);
    }

    @Override
    public Endereco getById(Long id) {
	Endereco entity;
	try {
	    entity = em.find(Endereco.class, id);
	} catch (NoResultException nre) {
	    entity = null;
	}

	return entity;
    }

    @Override
    public List<Endereco> listAll(Integer startResult, Integer maxResult) {
	final TypedQuery<Endereco> findAllQuery = em.createQuery("SELECT DISTINCT e FROM Endereco e ORDER BY e.id",
		Endereco.class);
	if (startResult != null) {
	    findAllQuery.setFirstResult(startResult);
	}
	if (maxResult != null) {
	    findAllQuery.setMaxResults(maxResult);
	}
	final List<Endereco> results = findAllQuery.getResultList();
	return results;
    }

}
