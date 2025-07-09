package com.app.vinyle.service;

import com.app.vinyle.domain.VinyleDomain;
import com.app.vinyle.mapper.VinyleMapper;
import com.app.vinyle.repository.VinyleRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.util.List;


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

    public Mono<List<VinyleDomain>> getAllVinyles() {
       return vinyleRepository.findAll().collectList()
                .map(vinyleEntities -> vinyleEntities.stream()
                        .map(VinyleMapper::entityToDomain)
                        .toList());
    }
}
