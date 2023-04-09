package com.ransu.lastperiodcommon.dto;

import java.util.ArrayList;
import java.util.List;

import com.ransu.lastperiodcommon.entity.AbilityEntity;
import com.ransu.lastperiodcommon.entity.AbilityEntity.Effect;
import com.ransu.lastperiodcommon.entity.AbilityEntity.Stage;

import lombok.Data;

@Data
public class AbilityDTO {

	// ID
	private String id;

	// スキル名称
	private String name;

	// どのスロットに属するアビリティか
	private int abilitySlot;

	// アートアビリティフラグ
	private Boolean artAbility;

	// アビリティの最大レベル
	private int maxLevel;

	// 効果オブジェクト
	private List<EffectDTO> effects;

	// アビリティレベルの各段階オブジェクト
	private List<StageDTO> stages;

	public AbilityDTO(AbilityEntity ability) {

		if(ability.getId() != null) {
			id = ability.getId().toHexString();
		}

		name = ability.getName();

		abilitySlot = ability.getAbilitySlot();

		artAbility = ability.getArtAbility();

		effects = new ArrayList<>();
		if(ability.getArtAbility() != null) {
			for(Effect effect: ability.getEffects()) {
				EffectDTO effectDTO = new EffectDTO(effect);
				effects.add(effectDTO);
			}
		}

		stages = new ArrayList<>();
		if(ability.getStages() != null) {
			for(Stage stage: ability.getStages()) {
				StageDTO stageDTO = new StageDTO(stage);
				stages.add(stageDTO);
				if(maxLevel < stage.getLevel()) {
					maxLevel = stage.getLevel();
				}
			}
		}
	}

	@Data
	public class EffectDTO {

		// 発動条件
		private String condition;

		// 対象ステータス
		private String status;

		// 初期値
		private Double arg;

		// 上昇量
		private Double amount;

		// パーセントフラグ
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

				amount = effect.getAmount();

				percentage = effect.getPercentage();
			}
		}
	}

	@Data
	public class StageDTO {

		// スキルレベル
		private int level;

		// 必要覚醒数
		private int awakening;

		public StageDTO(Stage stage) {

			if(stage != null) {

				level = stage.getLevel();

				awakening = stage.getAwakening();
			}
		}
	}
}
