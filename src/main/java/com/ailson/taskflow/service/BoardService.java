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

    public List<BoardDTO> findAll() {
        List<Board> boards = this.boardRepository.findAll();
        return boards.stream().map(BoardMapper::toDTO).toList();
    }

    public BoardDTO findById(Long id) {
        Board board = this.boardRepository.findById(id).orElseThrow();
        return BoardMapper.toDTO(board);
    }

    public void create(BoardRequest request) {
        Board board = BoardMapper.convertToCreate(request);
        this.boardRepository.save(board);
    }

    public void update(Long id, BoardRequest request) {
        Board board = this.boardRepository.findById(id).orElseThrow();
        Board boardUpdated = BoardMapper.convertToUpdate(board, request);
        this.boardRepository.save(boardUpdated);
    }

    public void delete(Long id) {
        this.boardRepository.deleteById(id);
    }
}
