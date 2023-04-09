package com.ransu.lastperiodcommon.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ransu.lastperiodcommon.entity.TypeEntity;

public interface TypeRepository extends MongoRepository<TypeEntity, String> {

	List<TypeEntity> findByName(String name);

	List<TypeEntity> findByIdNotAndName(ObjectId id, String name);
}
