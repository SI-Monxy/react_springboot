package com.example.backend.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.example.backend.entity.Task;

@SpringBootTest
@Sql("/sql/truncate-task.sql")
public class TaskRepositoryTest {

    @Autowired
    TaskRepository taskRepository;

    Task task;

    @BeforeEach
    public void setup() {
        // TODO: Date型のデータの表記がわからないのでテストデータを入れていない
        this.task = new Task(null, "設計作業", "タスクのCRUD処理の設計を行う", LocalDateTime.now(), "未着手", LocalDateTime.now(), null);

        // テスト対象のデータを投入
        taskRepository.insert(task);
    }

    @Test
    @DisplayName("タスクの新規登録")
    void testInsert() {
        // iDが自動採番されていることを確認する
        assertNotNull(task.getId());
    }

    @Test
    @DisplayName("Idを指定してタスクを取得")
    void testFindById() {
        // execute
        var targetTask = taskRepository.findById(task.getId());
        // assert
        assertThat(targetTask).isNotNull();
        assertThat(targetTask.getTitle()).isEqualTo(task.getTitle());
        assertThat(targetTask.getDescription()).isEqualTo(task.getDescription());
        // assertThat(targetTask.getDeadline()).isEqualTo(task.getDeadline());
        assertThat(targetTask.getStatus()).isEqualTo(task.getStatus());
        // assertThat(targetTask.getCreatedAt()).isEqualTo(task.getCreatedAt());
        // assertThat(targetTask.getUpdatedAt()).isEqualTo(task.getUpdatedAt());
    }
}
