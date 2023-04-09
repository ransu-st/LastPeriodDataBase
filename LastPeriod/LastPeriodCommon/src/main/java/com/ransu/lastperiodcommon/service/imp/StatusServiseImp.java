package com.ransu.lastperiodcommon.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ransu.lastperiodcommon.entity.StatusEntity;
import com.ransu.lastperiodcommon.repository.StatusRepository;
import com.ransu.lastperiodcommon.service.StatusService;

@Service
public class StatusServiseImp implements StatusService {

	@Autowired
	private StatusRepository repository;

	@Override
	public List<StatusEntity> getStatus() {
		return repository.findAll();
	}
}
