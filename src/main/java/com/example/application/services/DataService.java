package com.example.application.services;

import com.example.application.data.Data;
import com.example.application.data.DataRepository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    private final DataRepository repository;

    public DataService(DataRepository repository) {
        this.repository = repository;
    }

    public Optional<Data> get(Long id) {
        return repository.findById(id);
    }

    public Data update(Data entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<Data> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Data> list(Pageable pageable, Specification<Data> filter) {
        return repository.findAll(filter, pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
