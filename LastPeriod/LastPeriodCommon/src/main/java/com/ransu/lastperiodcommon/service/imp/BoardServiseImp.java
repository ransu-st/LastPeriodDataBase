package com.ransu.lastperiodcommon.service.imp;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ransu.lastperiodcommon.entity.BoardEntity;
import com.ransu.lastperiodcommon.repository.BoardRepository;
import com.ransu.lastperiodcommon.service.BoardService;

@Service
public class BoardServiseImp implements BoardService {

	@Autowired
	private BoardRepository repository;

	@Override
	public List<BoardEntity> getBoards() {
		return repository.findAll();
	}

	@Override
	public List<BoardEntity> getBoardsByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<BoardEntity> getBoardsByIdNotAndName(ObjectId id, String name) {
		return repository.findByIdNotAndName(id, name);
	}

	@Override
	public BoardEntity save(BoardEntity board) {
		return repository.save(board);
	}

	@Override
	public Boolean delete(BoardEntity board) {
		Boolean result = true;
		try {
			repository.delete(board);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
}
