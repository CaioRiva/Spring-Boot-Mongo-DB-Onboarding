package com.criva.onboardingproject.model.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

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

    public T save(T entity) {

        try {

            entityManager.persist(entity);
            entityManager.refresh(entity);
        } catch (Exception e) {

            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return entity;
    }

    public T update(T entity) {

        try {

            entity = entityManager.merge(entity);
        } catch (Exception e) {

            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return entity;
    }

    public void delete(T entity) {

        try {

            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        } catch (Exception e) {

            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public T findById(K id) {

        T entity = null;

        try {

             entity = entityManager.find(entityClass, id);
        } catch (Exception e) {

            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return entity;
    }
}