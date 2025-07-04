package com.app.vinyle.service;

import domain.Vinyle;
import com.app.vinyle.repository.VinyleRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class VinyleService {
    private final VinyleRepository vinyleRepository;

    public VinyleService(VinyleRepository vinyleRepository) {
        this.vinyleRepository = vinyleRepository;
    }

    public Mono<Vinyle> saveVinyle(Vinyle vinyle) {

    return  vinyleRepository.save(vinyle);
}

    public Flux<Vinyle> getAllVinyles() {
        return vinyleRepository.findAll();
    }
}
