package com.ransu.lastperiodcommon.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ransu.lastperiodcommon.entity.ConditionEntity;
import com.ransu.lastperiodcommon.repository.ConditionRepository;
import com.ransu.lastperiodcommon.service.ConditionService;

@Service
public class ConditionServiseImp implements ConditionService {

	@Autowired
	private ConditionRepository repository;

	@Override
	public List<ConditionEntity> getConditions() {
		return repository.findAll();
	}
}
