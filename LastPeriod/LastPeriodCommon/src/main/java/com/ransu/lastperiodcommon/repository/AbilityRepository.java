package com.ransu.lastperiodcommon.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ransu.lastperiodcommon.entity.AbilityEntity;

public interface AbilityRepository extends MongoRepository<AbilityEntity, String> {

	List<AbilityEntity> findByName(String name);

	List<AbilityEntity> findByIdNotAndName(ObjectId id, String name);
}
