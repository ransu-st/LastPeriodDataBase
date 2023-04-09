package com.ransu.lastperiodcommon.service.imp;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ransu.lastperiodcommon.entity.AbilityEntity;
import com.ransu.lastperiodcommon.repository.AbilityRepository;
import com.ransu.lastperiodcommon.service.AbilityService;

@Service
public class AbilityServiseImp implements AbilityService {

	@Autowired
	private AbilityRepository repository;

	@Override
	public List<AbilityEntity> getAbilities() {
		return repository.findAll();
	}

	@Override
	public List<AbilityEntity> getAbilitiesByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<AbilityEntity> getAbilitiesByIdNotAndName(ObjectId id, String name) {
		return repository.findByIdNotAndName(id, name);
	}

	@Override
	public AbilityEntity save(AbilityEntity ability) {
		return repository.save(ability);
	}

	@Override
	public Boolean delete(AbilityEntity ability) {
		Boolean result = true;
		try {
			repository.delete(ability);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
}
