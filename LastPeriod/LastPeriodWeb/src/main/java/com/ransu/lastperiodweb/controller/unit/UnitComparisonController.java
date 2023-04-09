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

import com.ransu.lastperiodcommon.entity.AbilityEntity;
import com.ransu.lastperiodcommon.entity.BoardEntity;
import com.ransu.lastperiodcommon.entity.UnitEntity;
import com.ransu.lastperiodcommon.service.AbilityService;
import com.ransu.lastperiodcommon.service.BoardService;
import com.ransu.lastperiodcommon.service.UnitService;
import com.ransu.lastperiodcommon.util.Constants;
import com.ransu.lastperiodcommon.util.JsonResult;
import com.ransu.lastperiodweb.dto.UnitChartDataDTO;
import com.ransu.lastperiodweb.form.UnitComparisonSearchForm;

@RestController
public class UnitComparisonController {

	@Autowired
	private UnitService unitService;

	@Autowired
	private AbilityService abilityService;

	@Autowired
	private BoardService boardService;


	/************************************************
	 *
	 * ユニットのグラフデータ取得用コントローラー
	 *
	 ************************************************/
	@RequestMapping(value="/getUnitGraphData", method=RequestMethod.GET)
	public JsonResult<List<UnitChartDataDTO>> getUnitGraphData(UnitComparisonSearchForm form) {

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

		// ユニットのアビリティMapを作成
		Map<ObjectId, AbilityEntity> abilityMap = new HashMap<>();
		List<AbilityEntity> ability = abilityService.getAbilities();
		for (AbilityEntity data: ability) {
			abilityMap.put(data.getId(), data);
		}

		// ユニットのボードMapを作成
		Map<ObjectId, BoardEntity> boardMap = new HashMap<>();
		List<BoardEntity> board = boardService.getBoards();
		for (BoardEntity data: board) {
			boardMap.put(data.getId(), data);
		}

		List<UnitChartDataDTO> result = new ArrayList<>();
		for (UnitEntity data: unitList) {
			result.add(new UnitChartDataDTO(form, data, abilityMap, boardMap));
		}
		return new JsonResult<List<UnitChartDataDTO>>(Constants.successCode, Constants.successMsg, result);
	}

}
