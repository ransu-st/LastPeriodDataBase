package com.ransu.lastperiodcommon.service.imp;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.ransu.lastperiodcommon.entity.UnitEntity;
import com.ransu.lastperiodcommon.repository.UnitRepository;
import com.ransu.lastperiodcommon.service.UnitService;

@Service
public class UnitServiceImp implements UnitService {

	@Autowired
	private UnitRepository repository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public UnitEntity getUnitById(ObjectId id) {
		return repository.findById(id);
	}

	@Override
	public List<UnitEntity> getUnitByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<UnitEntity> getUnitByIdNotAndName(ObjectId id, String name) {
		return repository.findByIdNotAndName(id, name);
	}

	@Override
	public List<UnitEntity> getUnitSearch(Query query) {
		return mongoTemplate.find(query, UnitEntity.class);
	}

	@Override
	public UnitEntity save(UnitEntity units) {
		return repository.save(units);
	}

	@Override
	public Boolean delete(UnitEntity units) {
		Boolean result = true;
		try {
			repository.delete(units);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
}
