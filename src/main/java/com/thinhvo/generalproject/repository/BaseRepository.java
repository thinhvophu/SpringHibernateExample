package com.thinhvo.generalproject.repository;

import com.thinhvo.generalproject.domain.BaseEntity;

import java.io.Serializable;

/**
 * Created by Thinh Vo on 3/8/2016.
 */
public interface BaseRepository<T extends BaseEntity, K extends Serializable> {
    T findById(K k);
    // TODO: some methods for all repository here 
}
