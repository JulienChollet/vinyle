package com.app.vinyle.service;

import com.app.vinyle.domain.VinyleDomain;
import com.app.vinyle.dto.VinyleRequest;
import com.app.vinyle.entity.VinyleEntity;
import com.app.vinyle.mapper.VinyleMapper;
import com.app.vinyle.repository.VinyleRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Objects;


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
       return vinyleRepository.findAll().map(VinyleMapper::entityToDomain);
    }

    public Mono<Boolean> deleteOneVinyleById(String id){
        return vinyleRepository.findById(id)
                .flatMap(vinyleEntity ->
                    vinyleRepository.deleteById(vinyleEntity.getId()).thenReturn(true))
                .defaultIfEmpty(false);
    }

    public Mono<VinyleDomain> getOneVinyleById(String id) {
        return vinyleRepository.findById(id)
                .map(VinyleMapper::entityToDomain);
    }

    public Mono<VinyleDomain> partialUpdate(String id, Map<String, Objects> fields){
        Mono<VinyleEntity> existingVinyle = vinyleRepository.findById(id).switchIfEmpty(Mono.empty());

        return null;

    }
}
