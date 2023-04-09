package com.ransu.lastperiodcommon.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "abilities")
public class AbilityEntity {

	@Id
	private ObjectId id;

	private String name;

	// アビリティのスロット番号
	private int abilitySlot;

	private Boolean artAbility;

	private List<Effect> effects;

	private List<Stage> stages;

	@Data
	public static class Effect {

		private ObjectId condition;

		private ObjectId status;

		private Double arg;

		private Double amount;

		private Boolean percentage;
	}

	@Data
	public static class Stage {

		private int level;

		private int awakening;
	}
}
