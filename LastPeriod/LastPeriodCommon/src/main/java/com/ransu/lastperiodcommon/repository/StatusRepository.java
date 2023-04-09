package com.ransu.lastperiodcommon.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ransu.lastperiodcommon.entity.StatusEntity;

public interface StatusRepository extends MongoRepository<StatusEntity, String> {

}
