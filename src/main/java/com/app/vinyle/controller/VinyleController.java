package com.app.vinyle.controller;

import com.app.vinyle.domain.VinyleDomain;
import com.app.vinyle.dto.VinyleRequest;
import com.app.vinyle.dto.VinyleResponse;
import com.app.vinyle.mapper.VinyleMapper;
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
    public Mono<ResponseEntity<VinyleResponse>> createVinyle(@RequestBody Mono<VinyleRequest> vinyleMono) {
    return vinyleMono
            .map(VinyleMapper::vinyleRequestToDomain)
            .flatMap(vinyleService::saveVinyle)
            .map(VinyleMapper::vinyleDomainToResponse)
            .map(response -> ResponseEntity.status(HttpStatus.CREATED).body(response))
            .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping("/vinyles")
    public Flux<VinyleDomain> getAllVinyles(){
        return vinyleService.getAllVinyles();
    }

    @GetMapping("/vinyle/{id}")
    public Mono<ResponseEntity<VinyleResponse>> getOneVinyleById(@PathVariable String id){
        return vinyleService.getOneVinyleById(id)
                .map(VinyleMapper::vinyleDomainToResponse)
                .map(vinyleResponse -> ResponseEntity.status(HttpStatus.OK).body(vinyleResponse))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @DeleteMapping("/vinyle/{id}")
    public Mono<ResponseEntity<String>> deleteVinyleById(@PathVariable String id){
        return vinyleService.deleteOneVinyleById(id)
                .map(response -> ResponseEntity.status(HttpStatus.OK).body(response + " " + id))
                .defaultIfEmpty(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le vinyle : " + id + " ne peut pas être effacé."));
    }

    @PatchMapping("/update/vinyle/{id}")
    public Mono<ResponseEntity<VinyleResponse>>


}
