package com.app.vinyle.controller;

import com.app.vinyle.Vinyle;
import com.app.vinyle.service.VinyleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/vinylotheque")
public class VinyleController {

    private final VinyleService vinyleService;

    public VinyleController( VinyleService vinyleService) {
        this.vinyleService = vinyleService;
    }

    @PostMapping("/vinyle")
public Mono<ResponseEntity<Vinyle>> vinyle(@RequestBody Mono<Vinyle> vinyleMono) {
    return vinyleMono.flatMap(vinyleService::saveVinyle)
            .map(savedVinyle -> ResponseEntity.status(HttpStatus.CREATED).body(savedVinyle))
            .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
}

}
