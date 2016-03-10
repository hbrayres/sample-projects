package com.selecao.ejb.dao;

import java.util.List;

import javax.ejb.Local;

import com.selecao.ejb.entity.Endereco;
import com.selecao.ejb.entity.filtro.FiltroEndereco;

/**
 * EJB Local para consulta dos dados de Endereco.
 * 
 * @author heber.junior
 *
 */
@Local
public interface EnderecoDao {

    /**
     * @param endereco
     */
    void salvar(final Endereco endereco);
    /**
     * @param id
     */
    void deletar(final Long id);
    /**
     * @param filtro
     * @return
     */
    List<Endereco> listar(final FiltroEndereco filtro);
    /**
     * @param id
     * @return
     */
    Endereco recuperar(final Long id);
}
