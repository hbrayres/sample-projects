package br.com.hbrayres.angular.facade;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.NoResultException;

import br.com.hbrayres.angular.model.Cliente;
import br.com.hbrayres.angular.model.Endereco;

@Local
public interface IFacadeLocal {
    
    Endereco persist(final Endereco endereco);
    
    void deleteEnderecoById(final Long id) throws NoResultException;

    Endereco getEnderecoById(final Long id);
    
    List<Endereco> listAllEndereco(final Integer startResult, final Integer maxResult);
    
    Cliente persist(final Cliente entity);
    
    void deleteClienteById(final Long id) throws NoResultException;

    Cliente getClienteById(final Long id);
    
    List<Cliente> listAllCliente(final Integer startResult, final Integer maxResult);
}
