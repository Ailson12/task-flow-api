package com.ailson.taskflow.mapper;

import com.ailson.taskflow.dto.board.BoardDTO;
import com.ailson.taskflow.model.Board;
import com.ailson.taskflow.request.BoardRequest;

public class BoardMapper {
    public static BoardDTO toDTO(Board board) {
        return new BoardDTO(
                board.getId(),
                board.getTitle(),
                board.getDescription()
        );
    }

    public static Board toCreate(BoardRequest request) {
        Board board = new Board();
        board.setTitle(request.getTitle());
        board.setDescription(request.getDescription());
        return board;
    }

    public static Board toUpdate(Board board, BoardRequest request) {
        board.setTitle(request.getTitle());
        board.setDescription(request.getDescription());
        return board;
    }
}
