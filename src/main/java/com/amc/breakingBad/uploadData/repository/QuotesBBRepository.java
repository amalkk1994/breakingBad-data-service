package com.amc.breakingBad.uploadData.repository;

import com.amc.breakingBad.uploadData.model.QuotesBB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuotesBBRepository extends MongoRepository<QuotesBB, String> {
}
