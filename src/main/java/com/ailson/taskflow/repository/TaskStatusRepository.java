package com.ailson.taskflow.repository;

import com.ailson.taskflow.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
    @Query("select ts from TaskStatus ts " +
            "inner join ts.boards as bo " +
            "where bo.id = :boardId")
    List<TaskStatus> findAllByBoard(Long boardId);
}
