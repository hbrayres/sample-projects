package br.com.hbrayres.angular.dao;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.NoResultException;

import br.com.hbrayres.angular.model.Endereco;

@Local
public interface IEnderecoDao {

    Endereco persist(final Endereco entity);
    
    void deleteById(final Long id) throws NoResultException;

    Endereco getById(final Long id);
    
    List<Endereco> listAll(final Integer startResult, final Integer maxResult);
    
}
