package com.ransu.lastperiodcommon.dto;

import com.ransu.lastperiodcommon.entity.AttributeEntity;

import lombok.Data;

@Data
public class AttributeDTO {

	private String id;

	private String name;

	public AttributeDTO(AttributeEntity attribute) {
		if(attribute.getId() != null) {
			id = attribute.getId().toHexString();
		}
		name = attribute.getName();
	}
}
