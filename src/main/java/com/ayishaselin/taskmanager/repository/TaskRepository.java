package com.ayishaselin.taskmanager.repository;

import com.ayishaselin.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;//ready-made database manager
import java.util.List;
public interface TaskRepository extends JpaRepository<Task, Long> {//Repository is interface.
List<Task> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
    String titleKeyword, 
    String descriptionKeyword);

List<Task> findByStatusIgnoreCase(String status);
}
