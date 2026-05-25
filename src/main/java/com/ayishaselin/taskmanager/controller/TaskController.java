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

}