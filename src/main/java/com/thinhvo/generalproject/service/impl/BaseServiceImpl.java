package com.thinhvo.generalproject.service.impl;

import com.thinhvo.generalproject.model.BaseModelObject;
import com.thinhvo.generalproject.repository.BaseRepository;
import com.thinhvo.generalproject.service.BaseService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

@Service
@Transactional
public abstract class BaseServiceImpl<T extends BaseModelObject, K extends Serializable> implements BaseService<T,K> {
    @Autowired
    protected DozerBeanMapper mapper;

    @Autowired
    protected BaseRepository<?,K> repository;

    protected Class<T> modelClass;

    protected Class<T> getModelClass() {
        if (modelClass == null) {
            ParameterizedType parent = (ParameterizedType) this.getClass().getGenericSuperclass();
            this.modelClass = (Class<T>) parent.getActualTypeArguments()[0];
        }
        return this.modelClass;
    }

    @Override
    public T findById(K k) {
        T result = mapper.map(repository.findById(k), getModelClass());
        return result;
    }
}
