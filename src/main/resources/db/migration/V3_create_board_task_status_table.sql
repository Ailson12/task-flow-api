CREATE TABLE IF NOT EXISTS board_task_status (
    task_status_id BIGINT NOT NULL,
    board_id BIGINT NOT NULL,
    PRIMARY KEY (task_status_id, board_id),
    FOREIGN KEY (task_status_id) REFERENCES task_status(id) ON DELETE CASCADE,
    FOREIGN KEY (board_id) REFERENCES boards(id) ON DELETE CASCADE
);
