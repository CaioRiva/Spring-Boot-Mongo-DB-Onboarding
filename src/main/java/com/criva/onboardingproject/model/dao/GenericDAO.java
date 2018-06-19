package com.criva.onboardingproject.model.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T extends Serializable, K> {

    T save(T entity);

    T update(T entity);

    void delete(T entity);

    T findById(K id);

    List<T> findAll();

}
