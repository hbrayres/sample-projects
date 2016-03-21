package br.com.hbrayres.angular.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import br.com.hbrayres.angular.dao.IClienteDao;
import br.com.hbrayres.angular.dao.IEnderecoDao;
import br.com.hbrayres.angular.model.Cliente;
import br.com.hbrayres.angular.model.Endereco;

@Stateless
public class FacadeImpl implements IFacadeLocal {

    @EJB
    private IClienteDao clienteDao;
    
    @EJB
    private IEnderecoDao enderecoDao;

    @Override
    public Endereco persist(final Endereco entity) {
	return enderecoDao.persist(entity);
    }

    @Override
    public void deleteEnderecoById(final Long id) throws NoResultException {
	enderecoDao.deleteById(id);
    }

    @Override
    public Endereco getEnderecoById(final Long id) {
	return enderecoDao.getById(id);
    }

    @Override
    public List<Endereco> listAllEndereco(final Integer startResult, final Integer maxResult) {
	return enderecoDao.listAll(startResult, maxResult);
    }

    @Override
    public Cliente persist(final Cliente entity) {
	return clienteDao.persist(entity);
    }

    @Override
    public void deleteClienteById(final Long id) throws NoResultException {
	clienteDao.deleteById(id);
    }

    @Override
    public Cliente getClienteById(final Long id) {
	return clienteDao.getById(id);
    }

    @Override
    public List<Cliente> listAllCliente(final Integer startResult, final Integer maxResult) {
	return clienteDao.listAll(startResult, maxResult);
    }

}
