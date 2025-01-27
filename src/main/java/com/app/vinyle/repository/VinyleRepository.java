package com.app.vinyle.repository;

import com.app.vinyle.Vinyle;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VinyleRepository extends ReactiveCrudRepository<Vinyle, String> {
}
