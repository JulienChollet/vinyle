package com.app.vinyle.controller;

import domain.Vinyle;
import com.app.vinyle.service.VinyleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("api/v1/vinylotheque")
public class VinyleController {

    private final VinyleService vinyleService;

    public VinyleController( VinyleService vinyleService) {
        this.vinyleService = vinyleService;
    }

    @PostMapping("/vinyle")
    public Mono<ResponseEntity<Vinyle>> createVinyle(@RequestBody Mono<Vinyle> vinyleMono) {
    return vinyleMono.flatMap(vinyleService::saveVinyle)
            .map(savedVinyle -> ResponseEntity.status(HttpStatus.CREATED).body(savedVinyle))
            .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping("/vinyles")
    public Flux<ResponseEntity<Vinyle>> getAllVinyles(){
        return vinyleService.getAllVinyles()
                .map(vinyle -> ResponseEntity.ok().body(vinyle));
    }

}
