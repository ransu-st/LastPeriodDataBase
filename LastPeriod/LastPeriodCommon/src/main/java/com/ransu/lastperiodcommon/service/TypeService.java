package com.ransu.lastperiodcommon.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.ransu.lastperiodcommon.entity.TypeEntity;

public interface TypeService {

	List<TypeEntity> getTypes();

	List<TypeEntity> getTypesByName(String name);

	List<TypeEntity> getTypesByIdNotAndName(ObjectId id, String name);

	TypeEntity save(TypeEntity type);

	Boolean delete(TypeEntity type);
}
