package com.ailson.taskflow.repository;

import com.ailson.taskflow.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT ta FROM Task ta WHERE ta.board.id = :boardId")
    List<Task> findAllByBoardId(Long boardId);
}
