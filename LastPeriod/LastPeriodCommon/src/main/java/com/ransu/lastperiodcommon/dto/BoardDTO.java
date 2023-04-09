package com.ransu.lastperiodcommon.dto;

import java.util.ArrayList;
import java.util.List;

import com.ransu.lastperiodcommon.entity.BoardEntity;
import com.ransu.lastperiodcommon.entity.BoardEntity.Effect;

import lombok.Data;

@Data
public class BoardDTO {

	private String id;

	private String name;

	private List<EffectDTO> effects;

	public BoardDTO(BoardEntity board) {

		if(board.getId() != null) {
			id = board.getId().toHexString();
		}

		name = board.getName();

		effects = new ArrayList<>();
		for(Effect effect: board.getEffects()) {
			EffectDTO effectDTO = new EffectDTO(effect);
			effects.add(effectDTO);
		}

	}

	@Data
	public class EffectDTO {

		// 発動条件
		private String condition;

		// 対象ステータス
		private String status;

		// 効果値
		private Double arg;

		//パーセントフラグ
		private Boolean percentage;

		public EffectDTO(Effect effect) {

			if(effect != null) {
				if(effect.getCondition() != null) {
					condition = effect.getCondition().toHexString();
				}

				if(effect.getStatus() != null) {
					status = effect.getStatus().toHexString();
				}

				arg = effect.getArg();

				percentage = effect.getPercentage();
			}
		}
	}
}
