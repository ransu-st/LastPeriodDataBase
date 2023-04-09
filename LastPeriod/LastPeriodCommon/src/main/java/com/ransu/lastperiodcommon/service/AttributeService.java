package com.ransu.lastperiodcommon.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.ransu.lastperiodcommon.entity.AttributeEntity;

public interface AttributeService {

	List<AttributeEntity> getAttributes();

	List<AttributeEntity> getAttributesByIdNotAndName(ObjectId id, String name);

	List<AttributeEntity> getAttributesByName(String name);

	AttributeEntity save(AttributeEntity attribute);

	Boolean delete(AttributeEntity attribute);
}
