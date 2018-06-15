package com.criva.onboardingproject.model.dao;

import java.io.Serializable;

public interface GenericDAO<T extends Serializable, K> {

    public T save(T entity);

    public T update(T entity);

    public void delete(T entity);

    public T findById(K id);
}
