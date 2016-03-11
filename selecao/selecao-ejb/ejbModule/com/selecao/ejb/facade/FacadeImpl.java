package com.selecao.ejb.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.selecao.ejb.dao.EnderecoDao;
import com.selecao.ejb.entity.Endereco;
import com.selecao.ejb.entity.filtro.FiltroEndereco;

@Stateless(mappedName = "facade")
public class FacadeImpl implements FacadeLocal {

    /**
     * DAO de Endereco injetado na fachada.
     */
    @EJB
    private EnderecoDao enderecoDao;
    
    @Override
    public void saveEndereco(final Endereco endereco) {
	enderecoDao.salvar(endereco);
    }

    @Override
    public void deleteEndereco(final Long id) {
	enderecoDao.deletar(id);
    }

    @Override
    public List<Endereco> listAllEndereco() {
	return enderecoDao.listar(null);
    }
    
    @Override
    public List<Endereco> listEndereco(final FiltroEndereco filtro) {
        return enderecoDao.listar(filtro);
    }

    @Override
    public Endereco getEndereco(final Long id) {
	return enderecoDao.recuperar(id);
    }

}
