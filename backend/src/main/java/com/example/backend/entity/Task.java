package com.example.backend.entity;

import java.util.Date;

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
    private Date deadline;
    private String status;
    private Date createdAt;
    private Date updatedAt;
}
