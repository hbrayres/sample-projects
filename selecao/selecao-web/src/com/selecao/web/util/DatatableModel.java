/*
 * Copyright (C) 2015 Samsung Electronics Co., Ltd. All rights reserved.
 *
 * Mobile Communication Division,
 * Digital Media & Communications Business, Samsung Electronics Co., Ltd.
 *
 * This software and its documentation are confidential and proprietary
 * information of Samsung Electronics Co., Ltd.  No part of the software and
 * documents may be copied, reproduced, transmitted, translated, or reduced to
 * any electronic medium or machine-readable form without the prior written
 * consent of Samsung Electronics.
 *
 * Samsung Electronics makes no representations with respect to the contents,
 * and assumes no responsibility for any errors that might appear in the
 * software and documents. This publication and the contents hereof are subject
 * to change without notice.
 */
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
