package com.ailson.taskflow.service;

import com.ailson.taskflow.dto.board.BoardDTO;
import com.ailson.taskflow.dto.task.TaskDTO;
import com.ailson.taskflow.mapper.TaskMapper;
import com.ailson.taskflow.model.Board;
import com.ailson.taskflow.model.Task;
import com.ailson.taskflow.model.TaskStatus;
import com.ailson.taskflow.repository.TaskRepository;
import com.ailson.taskflow.request.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskStatusService taskStatusService;

    @Autowired
    private BoardService boardService;

    public List<TaskDTO> findAllByBoard(Long boardId) {
        List<Task> tasks = this.taskRepository.findAllByBoardId(boardId);
        return tasks.stream().map(TaskMapper::toDTO).toList();
    }

    @Transactional
    public void create(TaskRequest request) {
        TaskStatus taskStatus = taskStatusService
                .findById(request.getTaskStatusId())
                .orElseThrow();

        BoardDTO boardDTO = this.boardService.findById(request.getBoardId());
        Board board = new Board(boardDTO.id());

        Task task = TaskMapper.toCreate(request);
        task.setTaskStatus(taskStatus);
        task.setBoard(board);

        this.taskRepository.save(task);
    }

    @Transactional
    public void delete(Long id) {
        this.taskRepository.deleteById(id);
    }
}
