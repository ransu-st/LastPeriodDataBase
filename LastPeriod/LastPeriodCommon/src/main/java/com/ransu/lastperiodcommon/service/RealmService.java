package com.ransu.lastperiodcommon.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.ransu.lastperiodcommon.entity.RealmEntity;

public interface RealmService {

	List<RealmEntity> getRealms();

	List<RealmEntity> getRealmsByName(String name);

	List<RealmEntity> getRealmsByIdNotAndName(ObjectId id, String name);

	RealmEntity save(RealmEntity realm);

	Boolean delete(RealmEntity realm);
}
