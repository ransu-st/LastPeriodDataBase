package com.ransu.lastperiodcommon.dto;

import com.ransu.lastperiodcommon.entity.StatusEntity;

import lombok.Data;

@Data
public class StatusDTO {

	private String id;

	private String name;

	public StatusDTO(StatusEntity status) {
		if(status.getId() != null) {
			id = status.getId().toHexString();
		}
		name = status.getName();
	}
}
