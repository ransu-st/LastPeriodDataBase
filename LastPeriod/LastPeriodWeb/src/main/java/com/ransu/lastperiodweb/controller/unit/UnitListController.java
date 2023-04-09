package com.ransu.lastperiodweb.controller.unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ransu.lastperiodcommon.entity.AttributeEntity;
import com.ransu.lastperiodcommon.entity.RealmEntity;
import com.ransu.lastperiodcommon.entity.SexEntity;
import com.ransu.lastperiodcommon.entity.TypeEntity;
import com.ransu.lastperiodcommon.entity.UnitEntity;
import com.ransu.lastperiodcommon.service.AttributeService;
import com.ransu.lastperiodcommon.service.RealmService;
import com.ransu.lastperiodcommon.service.SexService;
import com.ransu.lastperiodcommon.service.TypeService;
import com.ransu.lastperiodcommon.service.UnitService;
import com.ransu.lastperiodcommon.util.Constants;
import com.ransu.lastperiodcommon.util.JsonResult;
import com.ransu.lastperiodweb.dto.UnitListDTO;
import com.ransu.lastperiodweb.form.UnitListSearchForm;

@RestController
public class UnitListController {

	@Autowired
	private UnitService unitService;

	@Autowired
	private SexService sexService;

	@Autowired
	private TypeService typeService;

	@Autowired
	private RealmService realmService;

	@Autowired
	private AttributeService attributeService;

	@RequestMapping(value="/getUnitDataList", method=RequestMethod.GET)
	public JsonResult<List<UnitListDTO>> unitCreate(UnitListSearchForm form) {

		Query query = new Query();

		Criteria unitCriteria = new Criteria();
		if (form.getName() != null) {
			unitCriteria.and("name").regex(form.getName());
		}
		if (form.getRea() != null) {
			unitCriteria.and("rea").in(form.getRea());
		}
		if (form.getSex() != null) {
			unitCriteria.and("sex").in(form.getSex());
		}
		if (form.getRealm() != null) {
			unitCriteria.and("realm").in(form.getRealm());
		}
		if (form.getType() != null) {
			unitCriteria.and("type").in(form.getType());
		}
		if (form.getAttribute() != null) {
			unitCriteria.and("attribute").in(form.getAttribute());
		}
		query.addCriteria(unitCriteria);

		// ユニットデータを取得
		List<UnitEntity> unitList = unitService.getUnitSearch(query);

		// ユニットデータの各項目を置き換えるMapを作成
		Map<ObjectId, String> sexMap = new HashMap<>();
		List<SexEntity> sex = sexService.getSexs();
		for (SexEntity data: sex) {
			sexMap.put(data.getId(), data.getName());
		}

		Map<ObjectId, String> attributeMap = new HashMap<>();
		List<AttributeEntity> attribute = attributeService.getAttributes();
		for (AttributeEntity data: attribute) {
			attributeMap.put(data.getId(), data.getName());
		}

		Map<ObjectId, String> realmMap = new HashMap<>();
		List<RealmEntity> realm = realmService.getRealms();
		for (RealmEntity data: realm) {
			realmMap.put(data.getId(), data.getName());
		}

		Map<ObjectId, String> typeMap = new HashMap<>();
		List<TypeEntity> type = typeService.getTypes();
		for (TypeEntity data: type) {
			typeMap.put(data.getId(), data.getName());
		}

		List<UnitListDTO> result = new ArrayList<>();
		for (UnitEntity data: unitList) {
			result.add(new UnitListDTO(data, sexMap, attributeMap, realmMap, typeMap));
		}
		return new JsonResult<List<UnitListDTO>>(Constants.successCode, Constants.successMsg, result);
	}
}
