package com.ransu.lastperiodcommon.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.ransu.lastperiodcommon.entity.AbilityEntity;

public interface AbilityService {

	List<AbilityEntity> getAbilities();

	List<AbilityEntity> getAbilitiesByName(String name);

	List<AbilityEntity> getAbilitiesByIdNotAndName(ObjectId id, String name);

	AbilityEntity save(AbilityEntity ability);

	Boolean delete(AbilityEntity ability);
}
