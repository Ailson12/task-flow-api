package com.ailson.taskflow.mapper;

import com.ailson.taskflow.dto.board.BoardDTO;
import com.ailson.taskflow.model.Board;
import com.ailson.taskflow.request.BoardRequest;

public class BoardMapper {
    public static BoardDTO toDTO(Board board) {
        return new BoardDTO(
                board.getId(),
                board.getTitle()
        );
    }

    public static Board convertToCreate(BoardRequest request) {
        Board board = new Board();
        board.setTitle(request.getTitle());
        return board;
    }

    public static Board convertToUpdate(Board board, BoardRequest request) {
        board.setTitle(request.getTitle());
        return board;
    }
}
