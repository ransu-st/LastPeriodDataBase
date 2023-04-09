package com.ransu.lastperiodcommon.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ransu.lastperiodcommon.entity.ConditionEntity;

public interface ConditionRepository extends MongoRepository<ConditionEntity, String> {

}
