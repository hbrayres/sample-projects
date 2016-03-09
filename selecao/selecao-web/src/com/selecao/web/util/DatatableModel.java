package com.selecao.web.util;

import java.util.List;

/**
 * Classe responsavel por receber os dados da consulta e exibir na pagina na jQuery.datatable.
 * 
 * @author heber.junior
 *
 * @param <T> Generic type
 */
public class DatatableModel<T> {

    private Integer draw;
    private Integer recordsTotal;
    private Integer recordsFiltered;
    private List<T> data;
    
    public DatatableModel(final Integer draw1, final Integer total, 
	    final Integer filtered, final List<T> data1) {
	draw = draw1;
	recordsTotal = total;
	recordsFiltered = filtered;
	data = data1;
    }

    public Integer getDraw() {
	return draw;
    }

    public void setDraw(Integer draw) {
	this.draw = draw;
    }

    public Integer getRecordsTotal() {
	return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
	this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
	return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
	this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
	return data;
    }

    public void setData(List<T> data) {
	this.data = data;
    }

}
