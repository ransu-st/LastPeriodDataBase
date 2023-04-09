package com.ransu.lastperiodcommon.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.ransu.lastperiodcommon.entity.BoardEntity;

public interface BoardService {

	List<BoardEntity> getBoards();

	List<BoardEntity> getBoardsByName(String name);

	List<BoardEntity> getBoardsByIdNotAndName(ObjectId id, String name);

	BoardEntity save(BoardEntity board);

	Boolean delete(BoardEntity board);
}
