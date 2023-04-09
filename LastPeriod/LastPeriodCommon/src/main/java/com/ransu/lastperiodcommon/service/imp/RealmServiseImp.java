package com.ransu.lastperiodcommon.service.imp;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ransu.lastperiodcommon.entity.RealmEntity;
import com.ransu.lastperiodcommon.repository.RealmRepository;
import com.ransu.lastperiodcommon.service.RealmService;

@Service
public class RealmServiseImp implements RealmService {

	@Autowired
	private RealmRepository repository;

	@Override
	public List<RealmEntity> getRealms() {
		return repository.findAll();
	}

	@Override
	public List<RealmEntity> getRealmsByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<RealmEntity> getRealmsByIdNotAndName(ObjectId id, String name) {
		return repository.findByIdNotAndName(id, name);
	}

	@Override
	public RealmEntity save(RealmEntity realm) {
		return repository.save(realm);
	}

	@Override
	public Boolean delete(RealmEntity realm) {
		Boolean result = true;
		try {
			repository.delete(realm);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
}
