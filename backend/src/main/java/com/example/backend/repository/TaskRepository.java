package com.example.backend.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.backend.entity.Task;

@Mapper
public interface TaskRepository {

    @Select("SELECT * FROM tasks")
    List<Task> findAll();

    @Select("SELECT * FROM tasks WHERE id = #{id}")
    Task findById(Long id);

    @Insert("INSERT INTO tasks (title, description, deadline, status, created_at, updated_at)" + 
            "VALUES (#{title}, #{description}, #{deadline}, #{status}, #{createdAt}, #{updatedAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Task task);

    @Update("UPDATE tasks SET title = #{title}, description = #{description}, deadline = #{deadline}, " +
            "status = #{status}, updated_at = #{updatedAt} WHERE id = #{id}")
    void update(Task task);

    @Delete("DELETE FROM tasks WHERE id = #{id}")
    void deleteById(Long id);
}
