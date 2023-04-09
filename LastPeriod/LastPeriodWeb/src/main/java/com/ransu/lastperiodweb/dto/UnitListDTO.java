package com.ransu.lastperiodweb.dto;

import java.util.Map;

import org.bson.types.ObjectId;

import com.ransu.lastperiodcommon.entity.UnitEntity;
import com.ransu.lastperiodcommon.util.Constants;

import lombok.Data;

@Data
public class UnitListDTO {

	private String id;

	private String name;

	private String sex;

	private String attribute;

	private String realm;

	private String type;

	private int rea;

	private Double hp;

	private Double attack;

	private Double speed;

	private int numberOfAttackStages;

	public UnitListDTO(UnitEntity unit, Map<ObjectId, String> sexMap, Map<ObjectId, String> attributeMap, Map<ObjectId, String> realmMap, Map<ObjectId, String> typeMap) {

		if (unit.getId() != null) {
			id = unit.getId().toHexString();
		}

		name = unit.getName();

		sex = sexMap.get(unit.getSex()) != null ? sexMap.get(unit.getSex()) : Constants.noSetting ;

		attribute = attributeMap.get(unit.getAttribute()) != null ? attributeMap.get(unit.getAttribute()) : Constants.noSetting ;

		realm = realmMap.get(unit.getRealm()) != null ? realmMap.get(unit.getRealm()) : Constants.noSetting ;

		type = typeMap.get(unit.getType()) != null ? typeMap.get(unit.getType()) : Constants.noSetting ;

		rea = unit.getRea();

		hp = unit.getHp();

		attack = unit.getAttack();

		speed = unit.getSpeed();

		numberOfAttackStages = unit.getNumberOfAttackStages();
	}
}
