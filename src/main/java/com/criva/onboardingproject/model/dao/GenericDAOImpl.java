package com.criva.onboardingproject.model.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
public abstract class GenericDAOImpl<T extends Serializable, K> implements GenericDAO<T, K>{

    @PersistenceContext
    private EntityManager entityManager;
    private final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {

        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @Transactional
    public T save(T entity) {

        entityManager.persist(entity);
        entityManager.refresh(entity);

        return entity;
    }

    @Transactional
    public T update(T entity) {

        entity = entityManager.merge(entity);

        return entity;
    }

    @Transactional
    public void delete(T entity) {

        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    @Transactional
    public T findById(K id) {

        return entityManager.find(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<T> findAll() {

        return entityManager.createQuery("FROM " + entityClass.getName()).getResultList();
    }
}