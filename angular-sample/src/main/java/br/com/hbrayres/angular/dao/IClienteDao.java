package br.com.hbrayres.angular.dao;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.NoResultException;

import br.com.hbrayres.angular.model.Cliente;

@Local
public interface IClienteDao {

    Cliente persist(final Cliente entity);
    
    void deleteById(final Long id) throws NoResultException;

    Cliente getById(final Long id);
    
    List<Cliente> listAll(final Integer startResult, final Integer maxResult);
    
}
