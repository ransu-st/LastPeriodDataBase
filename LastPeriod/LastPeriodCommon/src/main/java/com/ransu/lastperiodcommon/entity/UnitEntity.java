package com.ransu.lastperiodcommon.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "units")
public class UnitEntity {

	@Id
	private ObjectId id;

	private String name;

	private ObjectId sex;

	private int rea;

	// 期間限定フラグ
	private Boolean limited;

	private ObjectId realm;

	private ObjectId type;

	private ObjectId attribute;

	private Double hp;

	private Double attack;

	private Double speed;

	private ObjectId ability1;

	private ObjectId ability2;

	private ObjectId ability3;

	private List<Board> boards;

	private ObjectId leaderSkill;

	private Boolean irregular;

	// 攻撃段数
	private int numberOfAttackStages;

	@Data
	public static class Board {

		private ObjectId boardId;

		private int quantity;
	}
}
