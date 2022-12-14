package com.amc.breakingBad.uploadData.repository;

import com.amc.breakingBad.uploadData.model.CharactersBB;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharacterBBRepository extends MongoRepository<CharactersBB, String> {

   // CharactersBB findByChar_id(String char_id);
    CharactersBB findByName(String name);
}
