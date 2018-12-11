package com.bandq.spring.DAO;

import com.bandq.spring.Entities.Product;
import com.bandq.spring.Program.HibernateUtility;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractGenericRepository<E> implements GenericRepository<E> {

    private Class<E> entity;

    public AbstractGenericRepository(){
        this.entity = (Class<E>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    protected Session getSession(){
        return HibernateUtility.getSessionFactory().getCurrentSession();
    }

    public boolean update(E entity) {
        try {
            getSession().beginTransaction();
            getSession().saveOrUpdate(entity);
            getSession().getTransaction().commit();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean delete(int Id) {

        //Version doesn't seem to support transactions

        try {
     //       getSession().beginTransaction();
    E receivedEntity = (E) getSession().get(entity, Id);
    getSession().delete(receivedEntity);
   // getSession().getTransaction().commit();
            return true;
}catch (Exception e){
        return false;
        }

        }

    public E get(int Id) {
        getSession().beginTransaction();
        E receivedEntity = (E) getSession().get(entity, Id);
        getSession().getTransaction().commit();
        return receivedEntity;
    }

    public List<E> getAll() {
        getSession().beginTransaction();
        List<E> entityList = getSession().createCriteria(this.entity).list();
        getSession().getTransaction().commit();
        return entityList;
    }

    public void deleteAll() {
        List<E> entities = getAll();
        getSession().beginTransaction();
        for (E entityItem : entities){
            getSession().delete(entityItem);
        }
        getSession().getTransaction().commit();
    }

    public void clear() {
        getSession().clear();
    }

    public void flush() {
        HibernateUtility.getSessionFactory().close();
    }

    public Serializable add(E entity) {
        getSession().beginTransaction();
        getSession().save(entity);
        getSession().getTransaction().commit();
        return null;
    }
}
