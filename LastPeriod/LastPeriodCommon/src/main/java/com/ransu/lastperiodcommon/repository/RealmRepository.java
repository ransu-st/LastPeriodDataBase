package com.ransu.lastperiodcommon.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ransu.lastperiodcommon.entity.RealmEntity;

public interface RealmRepository extends MongoRepository<RealmEntity, String> {

	List<RealmEntity> findByName(String name);

	List<RealmEntity> findByIdNotAndName(ObjectId id, String name);
}
