package com.ransu.lastperiodcommon.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ransu.lastperiodcommon.entity.AttributeEntity;

public interface AttributeRepository extends MongoRepository<AttributeEntity, String> {
	List<AttributeEntity> findByName(String name);

	List<AttributeEntity> findByIdNotAndName(ObjectId id, String name);
}
