package com.ransu.lastperiodcommon.service.imp;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ransu.lastperiodcommon.entity.SexEntity;
import com.ransu.lastperiodcommon.repository.SexRepository;
import com.ransu.lastperiodcommon.service.SexService;

@Service
public class SexServiseImp implements SexService {

	@Autowired
	private SexRepository repository;

	@Override
	public List<SexEntity> getSexs() {
		return repository.findAll();
	}

	@Override
	public List<SexEntity> getSexsByIdNotAndName(ObjectId id, String name) {
		return repository.findByIdNotAndName(id, name);
	}

	@Override
	public List<SexEntity> getSexsByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public SexEntity save(SexEntity sex) {
		return repository.save(sex);
	}

	@Override
	public Boolean delete(SexEntity sex) {
		Boolean result = true;
		try {
			repository.delete(sex);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
}
