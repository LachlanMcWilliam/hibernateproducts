package com.bandq.spring.DAO;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<E> {

    boolean update(E entity);
    boolean delete(int id);
    E get(int Id);
    List<E> getAll();
    void deleteAll();
    void clear();
    void flush();
    Serializable add(E entity);

}
