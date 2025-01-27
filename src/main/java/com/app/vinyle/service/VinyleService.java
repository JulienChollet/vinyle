package com.app.vinyle.service;

import com.app.vinyle.Vinyle;
import com.app.vinyle.repository.VinyleRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class VinyleService {
    private final VinyleRepository vinyleRepository;

    public VinyleService(VinyleRepository vinyleRepository) {
        this.vinyleRepository = vinyleRepository;
    }

    public Mono<Vinyle> saveVinyle(Vinyle vinyle) {
    return vinyleRepository.save(vinyle);
}

}
