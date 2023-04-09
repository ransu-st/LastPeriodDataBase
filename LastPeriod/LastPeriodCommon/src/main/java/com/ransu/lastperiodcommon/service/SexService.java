package com.ransu.lastperiodcommon.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.ransu.lastperiodcommon.entity.SexEntity;

public interface SexService {

	List<SexEntity> getSexs();

	List<SexEntity> getSexsByIdNotAndName(ObjectId id, String name);

	List<SexEntity> getSexsByName(String name);

	SexEntity save(SexEntity sex);

	Boolean delete(SexEntity sex);
}
