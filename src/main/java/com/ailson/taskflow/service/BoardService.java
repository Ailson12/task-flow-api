package com.ailson.taskflow.service;

import com.ailson.taskflow.dto.board.BoardDTO;
import com.ailson.taskflow.mapper.BoardMapper;
import com.ailson.taskflow.model.Board;
import com.ailson.taskflow.model.TaskStatus;
import com.ailson.taskflow.repository.BoardRepository;
import com.ailson.taskflow.request.BoardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private TaskStatusService taskStatusService;

    public List<BoardDTO> findAll() {
        List<Board> boards = this.boardRepository.findAll();
        return boards.stream().map(BoardMapper::toDTO).toList();
    }

    public BoardDTO findById(Long id) {
        Board board = this.boardRepository.findById(id).orElseThrow();
        return BoardMapper.toDTO(board);
    }

    @Transactional
    public void create(BoardRequest request) {
        List<TaskStatus> newTaskStatus = this.taskStatusService.findAllByIds(
                request.getTaskStatusIds()
        );

        Board board = BoardMapper.toCreate(request);
        // need to synchronize the two models: board and task-status
        newTaskStatus.forEach((taskStatus) -> {
            board.getTaskStatus().add(taskStatus);
            taskStatus.getBoards().add(board);
        });

        this.boardRepository.save(board);
    }

    @Transactional
    public void update(Long id, BoardRequest request) {
        Board board = this.boardRepository.findById(id).orElseThrow();
        Board boardUpdated = BoardMapper.toUpdate(board, request);

        // remove old relationship
        board.getTaskStatus().forEach(taskStatus -> taskStatus.getBoards().remove(board));
        board.getTaskStatus().clear();

        List<TaskStatus> newTaskStatus = this.taskStatusService.findAllByIds(request.getTaskStatusIds());
        // need to synchronize the two models: board and task-status
        newTaskStatus.forEach(taskStatus -> {
            board.getTaskStatus().add(taskStatus);
            taskStatus.getBoards().add(board);
        });

        this.boardRepository.save(boardUpdated);
    }

    public void delete(Long id) {
        Board board = this.boardRepository.findById(id).orElseThrow();

        // remove old relationship
        board.getTaskStatus().forEach(taskStatus -> taskStatus.getBoards().remove(board));
        board.getTaskStatus().clear();

        this.boardRepository.delete(board);
    }
}
