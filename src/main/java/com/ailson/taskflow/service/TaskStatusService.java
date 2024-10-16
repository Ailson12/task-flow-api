package com.ailson.taskflow.service;

import com.ailson.taskflow.dto.taskStatus.TaskStatusDTO;
import com.ailson.taskflow.mapper.TaskStatusMapper;
import com.ailson.taskflow.model.TaskStatus;
import com.ailson.taskflow.repository.TaskStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskStatusService {
    @Autowired
    private TaskStatusRepository taskStatusRepository;

    public List<TaskStatusDTO> findAll() {
        List<TaskStatus> entities = this.taskStatusRepository.findAll();
        // method reference TaskStatusMapper::toDTO
        return entities.stream().map(TaskStatusMapper::toDTO).toList();
    }

    public List<TaskStatus> findAllByIds(List<Long> ids) {
        return this.taskStatusRepository.findAllById(ids);
    }
}
