package com.ailson.taskflow.mapper;

import com.ailson.taskflow.dto.board.BoardDTO;
import com.ailson.taskflow.model.Board;
import com.ailson.taskflow.request.BoardRequest;

public class BoardMapper {
    public BoardDTO toDTO(Board board) {
        return new BoardDTO(
                board.getId(),
                board.getTitle()
        );
    }

    public Board toEntity(BoardRequest request) {
        if (request == null) {
            return null;
        }

        Board board = new Board();
        board.setTitle(request.getTitle());
        return board;
    }
}
