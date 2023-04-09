package com.ransu.lastperiodweb.form;

import java.util.List;

import org.bson.types.ObjectId;

import lombok.Data;

@Data
public class UnitComparisonSearchForm {

	private String name;

	private List<Integer> rea;

	private List<ObjectId> sex;

	private List<ObjectId> realm;

	private List<ObjectId> type;

	private List<ObjectId> attribute;

	private int level;

	private ObjectId xAxis;

	private ObjectId yAxis;
}
