package com.app.vinyle.repository;

import com.app.vinyle.entity.VinyleEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VinyleRepository extends ReactiveMongoRepository<VinyleEntity, String> {
}
