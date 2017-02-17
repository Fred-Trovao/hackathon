package br.com.thesharks.hanckathon.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

    protected Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public GenericServiceImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

}
