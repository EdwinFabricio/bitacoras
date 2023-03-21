package com.nutri.bitacoras.service.generic.impl;

import com.nutri.bitacoras.exception.ResourceNotFoundException;
import com.nutri.bitacoras.repository.generic.GenericRepository;
import com.nutri.bitacoras.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class GenericServiceImpl <T> implements GenericService {

    @Autowired
    protected GenericRepository<T> genericRepository;

    @Override
    @Transactional(readOnly = true)
    public List findAll() {
        return genericRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(long id) {
        return genericRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id", id));
    }

    @Override
    @Transactional
    public T save(Object entity){
        return genericRepository.save((T)entity);
    }

    @Override
    @Transactional
    public void delete(long id){
        genericRepository.deleteById(id);
    }

    @Override
    @Transactional
    public long count() {
        return genericRepository.count();
    }
}
