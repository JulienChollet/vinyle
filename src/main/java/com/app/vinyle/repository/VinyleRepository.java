package com.app.vinyle.repository;

import com.app.vinyle.entity.VinyleEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VinyleRepository extends ReactiveCrudRepository<VinyleEntity, String> {
}
