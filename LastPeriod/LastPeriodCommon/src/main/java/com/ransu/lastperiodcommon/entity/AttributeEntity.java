package com.ransu.lastperiodcommon.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "attributes")
public class AttributeEntity {

	@Id
	private ObjectId id;

	private String name;
}
