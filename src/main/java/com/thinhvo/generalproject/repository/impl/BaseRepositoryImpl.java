package com.thinhvo.generalproject.repository.impl;

import com.thinhvo.generalproject.domain.BaseEntity;
import com.thinhvo.generalproject.repository.BaseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by Thinh Vo on 3/8/2016.
 * Abstract repository. It contains implementation of methods for all repository and declaration of methods which will 
 * be implemented in specify repositories
 */

public class BaseRepositoryImpl<T extends BaseEntity, K extends Serializable> implements BaseRepository<T, K> {

    @Autowired
    protected SessionFactory sessionFactory;
    
    /**
     *  specify repository
     */
    private Class<T> persistentClass;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Class<T> getPersistentClass() {
        if (persistentClass == null) {
            ParameterizedType parent = (ParameterizedType) this.getClass().getGenericSuperclass();
            this.persistentClass = (Class<T>) parent.getActualTypeArguments()[0];
        }
        return this.persistentClass;
    }

    @Override
    public T findById(K k) {
        T entity = getSession().get(getPersistentClass(), k);
        return entity;
    }
    // TODO: more implementations and declarations here  
}
