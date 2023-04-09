package com.ransu.lastperiodcommon.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ransu.lastperiodcommon.entity.UnitEntity;

@Repository
public interface UnitRepository extends MongoRepository<UnitEntity, String> {

	UnitEntity findById(ObjectId id);

	List<UnitEntity> findByName(String name);

	List<UnitEntity> findByIdNotAndName(ObjectId id, String name);
}
