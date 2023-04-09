package com.ransu.lastperiodcommon.service.imp;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ransu.lastperiodcommon.entity.AttributeEntity;
import com.ransu.lastperiodcommon.repository.AttributeRepository;
import com.ransu.lastperiodcommon.service.AttributeService;

@Service
public class AttributeServiseImp implements AttributeService {

	@Autowired
	private AttributeRepository repository;

	@Override
	public List<AttributeEntity> getAttributes() {
		return repository.findAll();
	}

	@Override
	public List<AttributeEntity> getAttributesByIdNotAndName(ObjectId id, String name) {
		return repository.findByIdNotAndName(id, name);
	}

	@Override
	public List<AttributeEntity> getAttributesByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public AttributeEntity save(AttributeEntity attribute) {
		return repository.save(attribute);
	}

	@Override
	public Boolean delete(AttributeEntity attribute) {
		Boolean result = true;
		try {
			repository.delete(attribute);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
}
