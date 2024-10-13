package com.ailson.taskflow.service;

import com.ailson.taskflow.mapper.BoardMapper;
import com.ailson.taskflow.model.Board;
import com.ailson.taskflow.repository.BoardRepository;
import com.ailson.taskflow.request.BoardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    private final BoardMapper boardMapper = new BoardMapper();

    public void create(BoardRequest request) {
        Board board = this.boardMapper.toEntity(request);
        this.boardRepository.save(board);
    }
}
