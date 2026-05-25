package com.ayishaselin.taskmanager.controller;

import com.ayishaselin.taskmanager.model.Task;
import com.ayishaselin.taskmanager.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

    @Autowired // Spring automatically creates repository object
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public String getTasks(Model model) { // Model sends data from controller → HTML page

        model.addAttribute("tasks", taskRepository.findAll());// sends data to HTML.
        model.addAttribute("task", new Task());

        return "index";
    }

    @GetMapping("/search")
    public String searchTask(@RequestParam String keyword, Model model) { // Take value from URL parameter

        model.addAttribute(
                "tasks",
                taskRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword));

        model.addAttribute("task", new Task());// Send matching task list to HTML

        return "index";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute Task task) {

        taskRepository.save(task);

        return "redirect:/tasks";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id) {

        taskRepository.deleteById(id);

        return "redirect:/tasks";
    }

    @GetMapping("/editTask/{id}")
    public String editTask(@PathVariable Long id, Model model) {

        Optional<Task> optionalTask = taskRepository.findById(id);

        Task task = optionalTask.get();

        model.addAttribute("task", task);

        model.addAttribute("tasks", taskRepository.findAll());

        return "index";
    }

    @GetMapping("/filter")
    public String filterTask(
            @RequestParam String status,
            Model model) {

        if (status.equalsIgnoreCase("All")) {

            model.addAttribute(
                    "tasks",
                    taskRepository.findAll());

        } else {

            model.addAttribute(
                    "tasks",
                    taskRepository.findByStatusIgnoreCase(status));
        }

        model.addAttribute("task", new Task());

        return "index";
    }
}