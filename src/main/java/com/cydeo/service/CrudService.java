package com.cydeo.service;

import com.cydeo.dto.RoleDTO;

import java.util.List;

public interface CrudService<T,ID> {
    T save(T object);
    T findById(ID id);
    List<T> findByAll();
    void deleteById(ID id);
}
