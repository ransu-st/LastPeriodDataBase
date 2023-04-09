package com.ransu.lastperiodcommon.dto;

import com.ransu.lastperiodcommon.entity.RealmEntity;

import lombok.Data;

@Data
public class RealmDTO {

	private String id;

	private String name;

	public RealmDTO(RealmEntity realm) {
		if(realm.getId() != null) {
			id = realm.getId().toHexString();
		}
		name = realm.getName();
	}
}
