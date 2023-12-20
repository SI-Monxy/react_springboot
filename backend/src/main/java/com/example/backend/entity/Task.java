package com.example.backend.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/*
 * タスクテーブル情報
 */
@Data
@Builder
@AllArgsConstructor
public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
