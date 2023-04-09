package com.ransu.lastperiodweb.dto;

import java.util.Map;

import org.bson.types.ObjectId;

import com.ransu.lastperiodcommon.entity.AbilityEntity;
import com.ransu.lastperiodcommon.entity.BoardEntity;
import com.ransu.lastperiodcommon.entity.UnitEntity;
import com.ransu.lastperiodcommon.util.Constants;
import com.ransu.lastperiodweb.form.UnitComparisonSearchForm;

import lombok.Data;

@Data
public class UnitChartDataDTO {

	private String label;

	private UnitChartData data;

	public UnitChartDataDTO(UnitComparisonSearchForm form, UnitEntity unit, Map<ObjectId, AbilityEntity> abiliryMap, Map<ObjectId, BoardEntity> boardMap) {

		int defaultLimitLevel = 70;
		if(unit.getRea() == 4) {
			defaultLimitLevel = 60;
		} else if(unit.getRea() == 3) {
			defaultLimitLevel = 50;
		} else if(unit.getRea() == 2) {
			defaultLimitLevel = 40;
		} else if(unit.getRea() == 1) {
			defaultLimitLevel = 30;
		}

		// レベル指定がない場合は各レアごとのデフォルト限界レベルに設定
		int level = form.getLevel() != 0 ? form.getLevel() : defaultLimitLevel;
		if(form.getLevel() > defaultLimitLevel) {
			level = defaultLimitLevel;
		}

		label = unit.getName() + " Lv:" + level;

		// レベルによる補正値を算出
		Double correction = 1d + Math.sqrt((Math.pow(999, 2) - 1) * (level - 1) / (defaultLimitLevel - 1)
				+ Math.pow((level - 1) / (defaultLimitLevel - 1), 2)) / 999;

		Double x = getTargetStatus(form.getXAxis(), unit, correction);
		Double y = getTargetStatus(form.getYAxis(), unit, correction);

		data = new UnitChartData(x, y);
	}

	// レベル、ステータス、アビリティ、ボードから値を算出
	public Double getTargetStatus(ObjectId statusId, UnitEntity unit, Double correction) {

		// HP ATTACK SPEED が選択されている場合
		if(statusId.equals(Constants.attkId)) {
			return Math.ceil(unit.getAttack() * correction);
		} else if (statusId.equals(Constants.hpId)) {
			return Math.ceil(unit.getHp() * correction);
		} else if (statusId.equals(Constants.speedId)) {
			return unit.getSpeed();
		}
		return 0d;
	}

	@Data
	public class UnitChartData {

		private Double x;

		private Double y;

		public UnitChartData(Double x, Double y) {
			this.x = x;
			this.y = y;
		}
	}
}
