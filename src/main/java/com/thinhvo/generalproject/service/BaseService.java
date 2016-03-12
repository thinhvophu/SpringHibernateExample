package com.thinhvo.generalproject.service;

import com.thinhvo.generalproject.model.BaseModelObject;

import java.io.Serializable;

public interface BaseService<T extends BaseModelObject, K extends Serializable> {
    T findById(K k);
    // TODO: declaration of all service methods 
}
