package com.app.vinyle.service;

import com.app.vinyle.domain.VinyleDomain;
import com.app.vinyle.mapper.VinyleMapper;
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

    public Mono<VinyleDomain> saveVinyle(VinyleDomain vinyle) {
        return  vinyleRepository.save(VinyleMapper.domainToEntity(vinyle))
                .map(VinyleMapper::entityToDomain);
    }

    public Flux<VinyleDomain> getAllVinyles() {
        return vinyleRepository.findAll()
                .map(VinyleMapper::entityToDomain);
    }
}
