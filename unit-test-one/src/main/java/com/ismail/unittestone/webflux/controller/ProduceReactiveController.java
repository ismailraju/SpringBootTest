package com.ismail.unittestone.webflux.controller;


import com.ismail.unittestone.model.Produce;
import com.ismail.unittestone.webflux.service.ProduceReactiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/produce/reactive")
public class ProduceReactiveController {

    @Autowired
    private ProduceReactiveService produceReactiveService;

//    @PostMapping(value = "/add")
//    public Mono<Produce> add(@RequestBody Produce produce) {
//        Mono<Produce> p = produceReactiveService.add(produce);
//        return p;
//
//    }


    @GetMapping(value = "/get")
    public Mono<Produce> getStatic() {
        Produce p = new Produce(1L, "glass", 2000);
        return Mono.just(p);

    }


}
