package com.ransu.lastperiodcommon.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ransu.lastperiodcommon.entity.BoardEntity;

public interface BoardRepository extends MongoRepository<BoardEntity, String> {

	List<BoardEntity> findByName(String name);

	List<BoardEntity> findByIdNotAndName(ObjectId id, String name);
}
