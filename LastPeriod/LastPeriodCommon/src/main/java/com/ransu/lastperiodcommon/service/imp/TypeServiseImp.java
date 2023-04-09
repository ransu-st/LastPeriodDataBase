package com.ransu.lastperiodcommon.service.imp;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ransu.lastperiodcommon.entity.TypeEntity;
import com.ransu.lastperiodcommon.repository.TypeRepository;
import com.ransu.lastperiodcommon.service.TypeService;

@Service
public class TypeServiseImp implements TypeService {

	@Autowired
	private TypeRepository repository;

	@Override
	public List<TypeEntity> getTypes() {
		return repository.findAll();
	}

	@Override
	public List<TypeEntity> getTypesByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<TypeEntity> getTypesByIdNotAndName(ObjectId id, String name) {
		return repository.findByIdNotAndName(id, name);
	}

	@Override
	public TypeEntity save(TypeEntity type) {
		return repository.save(type);
	}

	@Override
	public Boolean delete(TypeEntity type) {
		Boolean result = true;
		try {
			repository.delete(type);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
}
