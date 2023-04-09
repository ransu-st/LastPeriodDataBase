package com.ransu.lastperiodweb.controller.unit;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ransu.lastperiodcommon.dto.AbilityDTO;
import com.ransu.lastperiodcommon.dto.AttributeDTO;
import com.ransu.lastperiodcommon.dto.BoardDTO;
import com.ransu.lastperiodcommon.dto.RealmDTO;
import com.ransu.lastperiodcommon.dto.SexDTO;
import com.ransu.lastperiodcommon.dto.TypeDTO;
import com.ransu.lastperiodcommon.dto.UnitDTO;
import com.ransu.lastperiodcommon.entity.AbilityEntity;
import com.ransu.lastperiodcommon.entity.AttributeEntity;
import com.ransu.lastperiodcommon.entity.BoardEntity;
import com.ransu.lastperiodcommon.entity.RealmEntity;
import com.ransu.lastperiodcommon.entity.SexEntity;
import com.ransu.lastperiodcommon.entity.TypeEntity;
import com.ransu.lastperiodcommon.entity.UnitEntity;
import com.ransu.lastperiodcommon.service.AbilityService;
import com.ransu.lastperiodcommon.service.AttributeService;
import com.ransu.lastperiodcommon.service.BoardService;
import com.ransu.lastperiodcommon.service.RealmService;
import com.ransu.lastperiodcommon.service.SexService;
import com.ransu.lastperiodcommon.service.TypeService;
import com.ransu.lastperiodcommon.service.UnitService;
import com.ransu.lastperiodcommon.util.Constants;
import com.ransu.lastperiodcommon.util.JsonResult;

@RestController
public class UnitDetailController {

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

	@Autowired
	private AbilityService abilityService;

	@Autowired
	private BoardService boardService;


	/************************************************
	 *
	 * ユニット関連 追加・編集用コントローラー 一覧
	 *
	 ************************************************/


	/**
	 * ユニット編集・新規登録
	 * @param unit
	 * @return
	 */
	@RequestMapping(value="/unitCreateAndUpdate", method=RequestMethod.POST)
	public JsonResult<UnitDTO> unitCreate(@RequestBody UnitEntity unit) {
		unit = unitService.save(unit);
		return new JsonResult<UnitDTO>(Constants.successCode, Constants.successMsg, new UnitDTO(unit));
	}

	/**
	 * ユニットの性別一覧を追加・編集
	 * @param type
	 * @return typeDTO
	 */
	@RequestMapping(value="/sexCreateAndUpdate", method=RequestMethod.POST)
	public JsonResult<SexDTO> sexCreate(@RequestBody SexEntity sex) {
		sex = sexService.save(sex);
		return new JsonResult<SexDTO>(Constants.successCode, Constants.successMsg, new SexDTO(sex));
	}

	/**
	 * ユニットのタイプ一覧を追加・編集
	 * @param type
	 * @return typeDTO
	 */
	@RequestMapping(value="/typeCreateAndUpdate", method=RequestMethod.POST)
	public JsonResult<TypeDTO> typeCreate(@RequestBody TypeEntity type) {
		type = typeService.save(type);
		return new JsonResult<TypeDTO>(Constants.successCode, Constants.successMsg, new TypeDTO(type));
	}

	/**
	 * ユニットのレルム一覧に追加・編集
	 * @param realm
	 * @return realmDTO
	 */
	@RequestMapping(value="/realmCreateAndUpdate", method=RequestMethod.POST)
	public JsonResult<RealmDTO> realmCreate(@RequestBody RealmEntity realm) {
		realm = realmService.save(realm);
		return new JsonResult<RealmDTO>(Constants.successCode, Constants.successMsg, new RealmDTO(realm));
	}

	/**
	 * ユニットの属性一覧に追加・編集
	 * @param attribute
	 * @return attributeDTO
	 */
	@RequestMapping(value="/attributeCreateAndUpdate", method=RequestMethod.POST)
	public JsonResult<AttributeDTO> attributeCreate(@RequestBody AttributeEntity attribute) {
		attribute = attributeService.save(attribute);
		return new JsonResult<AttributeDTO>(Constants.successCode, Constants.successMsg, new AttributeDTO(attribute));
	}

	/**
	 * ユニットのアビリティ一覧に追加・編集
	 * @param ability
	 * @return abilityDTO
	 */
	@RequestMapping(value="/abilityCreateAndUpdate", method=RequestMethod.POST)
	public JsonResult<AbilityDTO> abilityCreate(@RequestBody AbilityEntity ability) {
		ability = abilityService.save(ability);
		return new JsonResult<AbilityDTO>(Constants.successCode, Constants.successMsg, new AbilityDTO(ability));
	}

	/**
	 * ユニットのボード一覧に追加・編集
	 * @param board
	 * @return boardDTO
	 */
	@RequestMapping(value="/boardCreateAndUpdate", method=RequestMethod.POST)
	public JsonResult<BoardDTO> boardCreate(@RequestBody BoardEntity board) {
		board = boardService.save(board);
		return new JsonResult<BoardDTO>(Constants.successCode, Constants.successMsg, new BoardDTO(board));
	}


	/************************************************
	 *
	 * ユニット関連 二重登録防止用コントローラー 一覧
	 *
	 ************************************************/


	/**
	 * ユニット一覧への重複確認
	 * @param id
	 * @param name
	 * @return Boolean true: 既に登録あり false: 未登録
	 */
	@RequestMapping(value="/unitVerification", method=RequestMethod.GET)
	public JsonResult<Boolean> unitVerification(String id, String name) {
		List<UnitEntity> units;
		// 更新の場合
		if (id != null && id != "") {
			ObjectId unitId = new ObjectId(id);
			units = unitService.getUnitByIdNotAndName(unitId, name);
		// 新規の場合
		} else {
			units = unitService.getUnitByName(name);
		}
		Boolean result = true;
		if (units.isEmpty()) {
			result = false;
		}
		return new JsonResult<Boolean>(Constants.successCode, Constants.successMsg, result);
	}

	/**
	 * ユニットの性別一覧への重複確認
	 * @param id
	 * @param name
	 * @return Boolean true: 既に登録あり false: 未登録
	 */
	@RequestMapping(value="/sexVerification", method=RequestMethod.GET)
	public JsonResult<Boolean> sexVerification(String id, String name) {
		List<SexEntity> sexs;
		// 更新の場合
		if (id != null && id != "") {
			ObjectId sexId = new ObjectId(id);
			sexs = sexService.getSexsByIdNotAndName(sexId, name);
		// 新規の場合
		} else {
			sexs = sexService.getSexsByName(name);
		}
		Boolean result = true;
		if (sexs.isEmpty()) {
			result = false;
		}
		return new JsonResult<Boolean>(Constants.successCode, Constants.successMsg, result);
	}

	/**
	 * ユニットのタイプ一覧への重複確認
	 * @param id
	 * @param name
	 * @return Boolean true: 既に登録あり false: 未登録
	 */
	@RequestMapping(value="/typeVerification", method=RequestMethod.GET)
	public JsonResult<Boolean> typeVerification(String id, String name) {
		List<TypeEntity> types;
		// 更新の場合
		if (id != null && id != "") {
			ObjectId typeId = new ObjectId(id);
			types = typeService.getTypesByIdNotAndName(typeId, name);
		// 新規の場合
		} else {
			types = typeService.getTypesByName(name);
		}
		Boolean result = true;
		if (types.isEmpty()) {
			result = false;
		}
		return new JsonResult<Boolean>(Constants.successCode, Constants.successMsg, result);
	}

	/**
	 * ユニットのレルム一覧への重複確認
	 * @param id
	 * @param name
	 * @return Boolean true: 既に登録あり false: 未登録
	 */
	@RequestMapping(value="/realmVerification", method=RequestMethod.GET)
	public JsonResult<Boolean> realmVerification(String id, String name) {
		List<RealmEntity> realms;
		// 更新の場合
		if (id != null && id != "") {
			ObjectId realmId = new ObjectId(id);
			realms = realmService.getRealmsByIdNotAndName(realmId, name);
		// 新規の場合
		} else {
			realms = realmService.getRealmsByName(name);
		}
		Boolean result = true;
		if (realms.isEmpty()) {
			result = false;
		}
		return new JsonResult<Boolean>(Constants.successCode, Constants.successMsg, result);
	}

	/**
	 * ユニットの属性一覧への重複確認
	 * @param id
	 * @param name
	 * @return Boolean true: 既に登録あり false: 未登録
	 */
	@RequestMapping(value="/attributeVerification", method=RequestMethod.GET)
	public JsonResult<Boolean> attributeVerification(String id, String name) {
		List<AttributeEntity> attributes;
		// 更新の場合
		if (id != null && id != "") {
			ObjectId attributeId = new ObjectId(id);
			attributes = attributeService.getAttributesByIdNotAndName(attributeId, name);
		// 新規の場合
		} else {
			attributes = attributeService.getAttributesByName(name);
		}
		Boolean result = true;
		if (attributes.isEmpty()) {
			result = false;
		}
		return new JsonResult<Boolean>(Constants.successCode, Constants.successMsg, result);
	}

	/**
	 * ユニットのアビリティ一覧への重複確認
	 * @param id
	 * @param name
	 * @return Boolean true: 既に登録あり false: 未登録
	 */
	@RequestMapping(value="/abilityVerification", method=RequestMethod.GET)
	public JsonResult<Boolean> abilityVerification(String id, String name) {

		List<AbilityEntity> abilities;
		// 更新の場合
		if (id != null && id != "") {
			ObjectId abilityId = new ObjectId(id);
			abilities = abilityService.getAbilitiesByIdNotAndName(abilityId, name);
		// 新規の場合
		} else {
			abilities = abilityService.getAbilitiesByName(name);
		}
		Boolean result = true;
		if (abilities.isEmpty()) {
			result = false;
		}
		return new JsonResult<Boolean>(Constants.successCode, Constants.successMsg, result);
	}

	/**
	 * ユニットのボード一覧への重複確認
	 * @param id
	 * @param name
	 * @return Boolean true: 既に登録あり false: 未登録
	 */
	@RequestMapping(value="/boardVerification", method=RequestMethod.GET)
	public JsonResult<Boolean> boardVerification(String id, String name) {
		List<BoardEntity> boards;
		// 更新の場合
		if (id != null && id != "") {
			ObjectId boardId = new ObjectId(id);
			boards = boardService.getBoardsByIdNotAndName(boardId, name);
		// 新規の場合
		} else {
			boards = boardService.getBoardsByName(name);
		}
		Boolean result = true;
		if (boards.isEmpty()) {
			result = false;
		}
		return new JsonResult<Boolean>(Constants.successCode, Constants.successMsg, result);
	}


	/************************************************
	 *
	 * ユニット関連 削除用コントローラー 一覧
	 *
	 ************************************************/


	/**
	 * ユニットのタイプ一覧から削除
	 * @param unit
	 * @return Boolean
	 */
	@RequestMapping(value="/unitDelete", method=RequestMethod.POST)
	public JsonResult<Boolean> unitDelete(@RequestBody UnitEntity unit) {
		Boolean result = unitService.delete(unit);
		return new JsonResult<Boolean>(Constants.successCode, Constants.successMsg, result);
	}

	/**
	 * ユニットのタイプ一覧から削除
	 * @param type
	 * @return Boolean
	 */
	@RequestMapping(value="/typeDelete", method=RequestMethod.POST)
	public JsonResult<Boolean> typeDelete(@RequestBody TypeEntity type) {
		Boolean result = typeService.delete(type);
		return new JsonResult<Boolean>(Constants.successCode, Constants.successMsg, result);
	}

	/**
	 * ユニットのレルム一覧から削除
	 * @param realm
	 * @return Boolean
	 */
	@RequestMapping(value="/realmDelete", method=RequestMethod.POST)
	public JsonResult<Boolean> realmDelete(@RequestBody RealmEntity realm) {
		Boolean result = realmService.delete(realm);
		return new JsonResult<Boolean>(Constants.successCode, Constants.successMsg, result);
	}

	/**
	 * ユニットの属性一覧から削除
	 * @param attribute
	 * @return Boolean
	 */
	@RequestMapping(value="/attributeDelete", method=RequestMethod.POST)
	public JsonResult<Boolean> attributeDelete(@RequestBody AttributeEntity attribute) {
		Boolean result = attributeService.delete(attribute);
		return new JsonResult<Boolean>(Constants.successCode, Constants.successMsg, result);
	}

	/**
	 * ユニットのアビリティ一覧から削除
	 * @param ability
	 * @return Boolean
	 */
	@RequestMapping(value="/abilityDelete", method=RequestMethod.POST)
	public JsonResult<Boolean> abilityDelete(@RequestBody AbilityEntity ability) {
		Boolean result = abilityService.delete(ability);
		return new JsonResult<Boolean>(Constants.successCode, Constants.successMsg, result);
	}

	/**
	 * ユニットのボード一覧から削除
	 * @param board
	 * @return Boolean
	 */
	@RequestMapping(value="/boardDelete", method=RequestMethod.POST)
	public JsonResult<Boolean> boardDelete(@RequestBody BoardEntity board) {
		Boolean result = boardService.delete(board);
		return new JsonResult<Boolean>(Constants.successCode, Constants.successMsg, result);
	}
}
