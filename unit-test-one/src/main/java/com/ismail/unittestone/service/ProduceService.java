package com.ismail.unittestone.service;


import com.ismail.unittestone.model.Produce;
import com.ismail.unittestone.repository.ProduceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProduceService {


    @Autowired
    private ProduceRepository productRepository;



    public ProduceService(ProduceRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Produce add(Produce produce) {
        return productRepository.save(produce);
    }

    public Produce get(Produce produce) {
        return productRepository.getById(produce.getId());
    }
    public List<Produce> getAll() {
        return productRepository.findAll();
    }
}
