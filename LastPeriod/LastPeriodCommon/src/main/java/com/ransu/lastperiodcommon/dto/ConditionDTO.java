package com.ransu.lastperiodcommon.dto;

import com.ransu.lastperiodcommon.entity.ConditionEntity;

import lombok.Data;

@Data
public class ConditionDTO {

	private String id;

	private String name;

	public ConditionDTO(ConditionEntity condition) {
		if(condition.getId() != null) {
			id = condition.getId().toHexString();
		}
		name = condition.getName();
	}
}
