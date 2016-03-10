package com.selecao.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;

import com.selecao.ejb.entity.Endereco;
import com.selecao.ejb.entity.filtro.FiltroEndereco;

/**
 * @author heber.junior
 *
 */
@Stateless
public class EnderecoDaoImpl implements EnderecoDao {

    @Override
    public void salvar(Endereco endereco) {
	// TODO Auto-generated method stub
    }

    @Override
    public void deletar(Long id) {
	// TODO Auto-generated method stub
    }

    @Override
    public List<Endereco> listar(FiltroEndereco filtro) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Endereco recuperar(Long id) {
	// TODO Auto-generated method stub
	return null;
    }

}
