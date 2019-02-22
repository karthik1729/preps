package io.alphadevs.data.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }

    public List<T> fetchAll(String queryStr, Page page) {
        Query query = getSession().createQuery(queryStr);
        List list = query.list();
        query.setFirstResult(page.getOffset());
        query.setMaxResults(page.getLimit());
        return list;
    }

    public void persist(T entity) {
        getSession().persist(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }

}
