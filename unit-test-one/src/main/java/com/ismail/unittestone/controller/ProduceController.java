package com.ismail.unittestone.controller;


import com.ismail.unittestone.service.ProduceService;
import com.ismail.unittestone.model.Produce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produce")
public class ProduceController {

    @Autowired
    private ProduceService produceService;

    @PostMapping(value = "/add")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produce> add(@RequestBody Produce produce) {
        Produce p = produceService.add(produce);
        return new ResponseEntity<Produce>(p, HttpStatus.CREATED);

    }


    @GetMapping(value = "/get")
    public ResponseEntity<List<Produce>> get() {
        List<Produce> p_all = produceService.getAll();
        return new ResponseEntity<List<Produce>>(p_all, HttpStatus.ACCEPTED);

    }

    @GetMapping(value = "/get-static")
    public ResponseEntity<Produce> getStatic() {
        Produce p = new Produce(1L, "glass", 2000);
        return new ResponseEntity<Produce>(p, HttpStatus.ACCEPTED);

    }


}
