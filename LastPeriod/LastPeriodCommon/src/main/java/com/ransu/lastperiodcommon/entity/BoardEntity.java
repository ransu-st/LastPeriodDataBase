package com.ransu.lastperiodcommon.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "boards")
public class BoardEntity {

	@Id
	private ObjectId id;

	private String name;

	private List<Effect> effects;

	@Data
	public static class Effect {

		private ObjectId condition;

		private ObjectId status;

		private Double arg;

		private Boolean percentage;
	}
}
