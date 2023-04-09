package com.ransu.lastperiodcommon.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "status")
public class StatusEntity {

	@Id
	private ObjectId id;

	private String name;
}
