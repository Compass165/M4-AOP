package com.exception.service;

public interface IGeneralService <T>{
    Iterable<T> findAll();

    T findById(Long id);

    void save(T model) throws Exception;

    void remove(Long id);
}
