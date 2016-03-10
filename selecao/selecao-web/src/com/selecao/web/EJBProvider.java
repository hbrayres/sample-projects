package com.selecao.web;

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
