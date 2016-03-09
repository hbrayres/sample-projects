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
package com.selecao.web.service;

import java.lang.reflect.Type;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.core.spi.component.ComponentContext;
import com.sun.jersey.core.spi.component.ComponentScope;
import com.sun.jersey.spi.inject.Injectable;
import com.sun.jersey.spi.inject.InjectableProvider;

@Provider
public class EJBProvider implements InjectableProvider<EJB, Type> {

    @Override
    public Injectable<?> getInjectable(ComponentContext cc, EJB ejb, Type t) {
        if (!(t instanceof Class)) return null;

        try {
            Class<?> c = (Class<?>)t;
            Context localContext = new InitialContext();

            final String beanName = String.format("java:comp/env/%s", c.getSimpleName());
            final Object localEjb = localContext.lookup(beanName);

            return new Injectable<Object>() {
                public Object getValue() {
                    return localEjb;
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ComponentScope getScope() {
	return ComponentScope.Singleton;
    }

}
