package com.ransu.lastperiodcommon.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Query;

import com.ransu.lastperiodcommon.entity.UnitEntity;

public interface UnitService {

	UnitEntity getUnitById(ObjectId id);

	List<UnitEntity> getUnitByName(String name);

	List<UnitEntity> getUnitByIdNotAndName(ObjectId id, String name);

	List<UnitEntity> getUnitSearch(Query query);

	UnitEntity save(UnitEntity units);

	Boolean delete(UnitEntity units);
}
