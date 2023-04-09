package com.ransu.lastperiodweb.controller.page;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ransu.lastperiodcommon.dto.AbilityDTO;
import com.ransu.lastperiodcommon.dto.AttributeDTO;
import com.ransu.lastperiodcommon.dto.BoardDTO;
import com.ransu.lastperiodcommon.dto.ConditionDTO;
import com.ransu.lastperiodcommon.dto.RealmDTO;
import com.ransu.lastperiodcommon.dto.SexDTO;
import com.ransu.lastperiodcommon.dto.StatusDTO;
import com.ransu.lastperiodcommon.dto.TypeDTO;
import com.ransu.lastperiodcommon.dto.UnitDTO;
import com.ransu.lastperiodcommon.entity.AbilityEntity;
import com.ransu.lastperiodcommon.entity.AttributeEntity;
import com.ransu.lastperiodcommon.entity.BoardEntity;
import com.ransu.lastperiodcommon.entity.ConditionEntity;
import com.ransu.lastperiodcommon.entity.RealmEntity;
import com.ransu.lastperiodcommon.entity.SexEntity;
import com.ransu.lastperiodcommon.entity.StatusEntity;
import com.ransu.lastperiodcommon.entity.TypeEntity;
import com.ransu.lastperiodcommon.entity.UnitEntity;
import com.ransu.lastperiodcommon.service.AbilityService;
import com.ransu.lastperiodcommon.service.AttributeService;
import com.ransu.lastperiodcommon.service.BoardService;
import com.ransu.lastperiodcommon.service.ConditionService;
import com.ransu.lastperiodcommon.service.RealmService;
import com.ransu.lastperiodcommon.service.SexService;
import com.ransu.lastperiodcommon.service.StatusService;
import com.ransu.lastperiodcommon.service.TypeService;
import com.ransu.lastperiodcommon.service.UnitService;

@Controller
public class PageController {

	@Autowired
	private UnitService unitService;

	@Autowired
	private SexService sexService;

	@Autowired
	private RealmService realmService;

	@Autowired
	private TypeService typeService;

	@Autowired
	private StatusService statusService;

	@Autowired
	private AttributeService attributeService;

	@Autowired
	private AbilityService abilityService;

	@Autowired
	private BoardService boardService;

	@Autowired
	private ConditionService conditionService;

	@RequestMapping(value="/mainPage", method=RequestMethod.GET)
	public ModelAndView mainDisp(ModelAndView mav) {
		mav.setViewName("main");
		return mav;
	}

	@RequestMapping(value="/unitListPage", method=RequestMethod.GET)
	public ModelAndView unitListDisp(ModelAndView mav) {

		List<SexEntity> sex = sexService.getSexs();
		List<SexDTO> sexList = new ArrayList<>();
		for (SexEntity data: sex) {
			SexDTO sexdto = new SexDTO(data);
			sexList.add(sexdto);
		}

		List<RealmEntity> realms = realmService.getRealms();
		List<RealmDTO> realmList = new ArrayList<>();
		for (RealmEntity data: realms) {
			RealmDTO realmdto = new RealmDTO(data);
			realmList.add(realmdto);
		}

		List<TypeEntity> types = typeService.getTypes();
		List<TypeDTO> typeList = new ArrayList<>();
		for (TypeEntity data: types) {
			TypeDTO typedto = new TypeDTO(data);
			typeList.add(typedto);
		}

		List<StatusEntity> status = statusService.getStatus();
		List<StatusDTO> statusList = new ArrayList<>();
		for (StatusEntity data: status) {
			StatusDTO statusdto = new StatusDTO(data);
			statusList.add(statusdto);
		}

		List<AttributeEntity> attributes = attributeService.getAttributes();
		List<AttributeDTO> attributeList = new ArrayList<>();
		for (AttributeEntity data: attributes) {
			AttributeDTO attributedto = new AttributeDTO(data);
			attributeList.add(attributedto);
		}

		mav.addObject("sex", sexList);
		mav.addObject("realms", realmList);
		mav.addObject("types", typeList);
		mav.addObject("status", statusList);
		mav.addObject("attributes", attributeList);
		mav.setViewName("unit/unitLIst");
		return mav;
	}

	@RequestMapping(value="/unitCreateAndEditPage", method=RequestMethod.GET)
	public ModelAndView unitEditAndDetailDisp(ModelAndView mav, @RequestParam(name = "id", required = false) ObjectId id) {

		// 編集画面の場合は編集対象のユニットデータを取得
		if (id != null) {
			UnitEntity unit = unitService.getUnitById(id);
			UnitDTO unitdto = new UnitDTO(unit);
			mav.addObject("unit", unitdto);
		}

		// ドロップダウンリストデータを取得
		List<SexEntity> sex = sexService.getSexs();
		List<SexDTO> sexList = new ArrayList<>();
		for (SexEntity data: sex) {
			SexDTO sexdto = new SexDTO(data);
			sexList.add(sexdto);
		}

		List<RealmEntity> realms = realmService.getRealms();
		List<RealmDTO> realmList = new ArrayList<>();
		for (RealmEntity data: realms) {
			RealmDTO realmdto = new RealmDTO(data);
			realmList.add(realmdto);
		}

		List<TypeEntity> types = typeService.getTypes();
		List<TypeDTO> typeList = new ArrayList<>();
		for (TypeEntity data: types) {
			TypeDTO typedto = new TypeDTO(data);
			typeList.add(typedto);
		}

		List<StatusEntity> status = statusService.getStatus();
		List<StatusDTO> statusList = new ArrayList<>();
		for (StatusEntity data: status) {
			StatusDTO statusdto = new StatusDTO(data);
			statusList.add(statusdto);
		}

		List<AttributeEntity> attributes = attributeService.getAttributes();
		List<AttributeDTO> attributeList = new ArrayList<>();
		for (AttributeEntity data: attributes) {
			AttributeDTO attributedto = new AttributeDTO(data);
			attributeList.add(attributedto);
		}

		List<ConditionEntity> conditions = conditionService.getConditions();
		List<ConditionDTO> conditionList = new ArrayList<>();
		for (ConditionEntity data: conditions) {
			ConditionDTO conditiondto = new ConditionDTO(data);
			conditionList.add(conditiondto);
		}

		List<AbilityEntity> abilities = abilityService.getAbilities();
		List<AbilityDTO> abilityList = new ArrayList<>();
		for (AbilityEntity data: abilities) {
			AbilityDTO abilityDTO = new AbilityDTO(data);
			abilityList.add(abilityDTO);
		}

		List<BoardEntity> boards = boardService.getBoards();
		List<BoardDTO> boardList = new ArrayList<>();
		for (BoardEntity data: boards) {
			BoardDTO boardDTO = new BoardDTO(data);
			boardList.add(boardDTO);
		}

		mav.addObject("sexs", sexList);
		mav.addObject("realms", realmList);
		mav.addObject("types", typeList);
		mav.addObject("status", statusList);
		mav.addObject("attributes", attributeList);
		mav.addObject("conditions", conditionList);
		mav.addObject("abilities", abilityList);
		mav.addObject("boards", boardList);
		mav.setViewName("unit/unitDetail");

		return mav;
	}

	@RequestMapping(value="/unitComparisonPage", method=RequestMethod.GET)
	public ModelAndView unitComparisonDisp(ModelAndView mav) {

		List<SexEntity> sex = sexService.getSexs();
		List<SexDTO> sexList = new ArrayList<>();
		for (SexEntity data: sex) {
			SexDTO sexdto = new SexDTO(data);
			sexList.add(sexdto);
		}

		List<RealmEntity> realms = realmService.getRealms();
		List<RealmDTO> realmList = new ArrayList<>();
		for (RealmEntity data: realms) {
			RealmDTO realmdto = new RealmDTO(data);
			realmList.add(realmdto);
		}

		List<TypeEntity> types = typeService.getTypes();
		List<TypeDTO> typeList = new ArrayList<>();
		for (TypeEntity data: types) {
			TypeDTO typedto = new TypeDTO(data);
			typeList.add(typedto);
		}

		List<StatusEntity> status = statusService.getStatus();
		List<StatusDTO> statusList = new ArrayList<>();
		for (StatusEntity data: status) {
			StatusDTO statusdto = new StatusDTO(data);
			statusList.add(statusdto);
		}

		List<AttributeEntity> attributes = attributeService.getAttributes();
		List<AttributeDTO> attributeList = new ArrayList<>();
		for (AttributeEntity data: attributes) {
			AttributeDTO attributedto = new AttributeDTO(data);
			attributeList.add(attributedto);
		}

		mav.addObject("sex", sexList);
		mav.addObject("realms", realmList);
		mav.addObject("types", typeList);
		mav.addObject("status", statusList);
		mav.addObject("attributes", attributeList);
		mav.setViewName("unit/unitComparison");
		return mav;
	}
}
