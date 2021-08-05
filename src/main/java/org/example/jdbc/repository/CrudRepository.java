package org.example.jdbc.repository;

import org.example.jdbc.model.BaseModel;

import java.util.List;

public interface CrudRepository<ID,T extends BaseModel<ID>> {

    List<T> findAll();

    T findByID(ID id);

    T creat (T t);

    T update(ID id,T t);

    void delete(ID id);

}
