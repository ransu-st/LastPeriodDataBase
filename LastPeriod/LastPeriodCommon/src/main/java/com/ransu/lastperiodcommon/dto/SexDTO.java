package com.ransu.lastperiodcommon.dto;

import com.ransu.lastperiodcommon.entity.SexEntity;

import lombok.Data;

@Data
public class SexDTO {

	private String id;

	private String name;

	public SexDTO(SexEntity sex) {
		if(sex.getId() != null) {
			id = sex.getId().toHexString();
		}
		name = sex.getName();
	}
}
