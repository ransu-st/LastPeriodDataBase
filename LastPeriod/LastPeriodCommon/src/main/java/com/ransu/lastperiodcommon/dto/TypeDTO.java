package com.ransu.lastperiodcommon.dto;

import com.ransu.lastperiodcommon.entity.TypeEntity;

import lombok.Data;

@Data
public class TypeDTO {

	private String id;

	private String name;

	public TypeDTO(TypeEntity type) {
		if(type.getId() != null) {
			id = type.getId().toHexString();
		}
		name = type.getName();
	}
}
