package com.ransu.lastperiodcommon.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ransu.lastperiodcommon.entity.SexEntity;

public interface SexRepository extends MongoRepository<SexEntity, String> {

	List<SexEntity> findByIdNotAndName(ObjectId id, String name);

	List<SexEntity> findByName(String name);
}
