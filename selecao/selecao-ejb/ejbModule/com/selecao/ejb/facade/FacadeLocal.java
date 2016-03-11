package com.selecao.ejb.facade;

import java.util.List;

import javax.ejb.Local;

import com.selecao.ejb.entity.Endereco;
import com.selecao.ejb.entity.filtro.FiltroEndereco;

/**
 * EJB Local Facade
 * 
 * @author heber.junior
 *
 */
@Local
public interface FacadeLocal {

    void saveEndereco(final Endereco endereco);
    
    void deleteEndereco(final Long id);
    
    List<Endereco> listAllEndereco();
    
    List<Endereco> listEndereco(final FiltroEndereco filtro);
    
    Endereco getEndereco(final Long id);
    
}
