package com.ailson.taskflow.service;

import com.ailson.taskflow.dto.board.BoardDTO;
import com.ailson.taskflow.mapper.BoardMapper;
import com.ailson.taskflow.model.Board;
import com.ailson.taskflow.repository.BoardRepository;
import com.ailson.taskflow.request.BoardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    private final BoardMapper boardMapper = new BoardMapper();

    public List<BoardDTO> findAll() {
        List<Board> boards = this.boardRepository.findAll();
        return boards.stream().map(this.boardMapper::toDTO).toList();
    }

    public BoardDTO findById(Long id) {
        Board board = this.boardRepository.findById(id).orElseThrow();
        return this.boardMapper.toDTO(board);
    }

    public void create(BoardRequest request) {
        Board board = this.boardMapper.toEntity(request);
        this.boardRepository.save(board);
    }
}
