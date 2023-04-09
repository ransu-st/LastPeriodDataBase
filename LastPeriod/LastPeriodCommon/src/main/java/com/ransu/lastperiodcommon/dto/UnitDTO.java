package com.ransu.lastperiodcommon.dto;

import java.util.ArrayList;
import java.util.List;

import com.ransu.lastperiodcommon.entity.UnitEntity;
import com.ransu.lastperiodcommon.entity.UnitEntity.Board;

import lombok.Data;

@Data
public class UnitDTO {

	private String id;

	private String name;

	private String sex;

	private int rea;

	private Boolean limited;

	private String realm;

	private String type;

	private String attribute;

	private Double hp;

	private Double attack;

	private Double speed;

	private String ability1;

	private String ability2;

	private String ability3;

	private List<BoardDTO> boards;

	private String leaderSkill;

	private Boolean irregular;

	// 攻撃段数
	private int numberOfAttackStages;

	public UnitDTO(UnitEntity unit) {
		if (unit.getId() != null) {
			id = unit.getId().toHexString();
		}
		name = unit.getName();

		if (unit.getSex() != null) {
			sex = unit.getSex().toHexString();
		}

		rea = unit.getRea();

		limited = unit.getLimited();

		if (unit.getRealm() != null) {
			realm = unit.getRealm().toHexString();
		}

		if (unit.getType() != null) {
			type = unit.getType().toHexString();
		}

		if (unit.getAttribute() != null) {
			attribute = unit.getAttribute().toHexString();
		}

		hp = unit.getHp();

		attack = unit.getAttack();

		speed = unit.getSpeed();

		if (unit.getAbility1() != null) {
			ability1 = unit.getAbility1().toHexString();
		}

		if (unit.getAbility2() != null) {
			ability2 = unit.getAbility2().toHexString();
		}

		if (unit.getAbility3() != null) {
			ability3 = unit.getAbility3().toHexString();
		}

		if (unit.getBoards() != null) {
			boards = new ArrayList<>();
			for (Board board: unit.getBoards()) {
				boards.add(new BoardDTO(board));
			}
		}

		if (unit.getLeaderSkill() != null) {
			leaderSkill = unit.getLeaderSkill().toHexString();
		}

		irregular = unit.getIrregular();

		numberOfAttackStages = unit.getNumberOfAttackStages();
	}

	@Data
	public class BoardDTO {

		private String boardId;

		private int quantity;

		public BoardDTO(Board board) {

			if (board.getBoardId() != null) {
				boardId = board.getBoardId().toHexString();
			}

			quantity = board.getQuantity();
		}
	}
}
