package com.cydeo.controller;

import com.cydeo.dto.TaskDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final ProjectService projectService;
    private final UserService userService;
    private final TaskService taskService;

    public TaskController(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String getTask(Model model) {
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employee", userService.findAll());
        model.addAttribute("tasks", taskService.findAll());

        return "task/create";
    }

    @PostMapping("/create")
    public String getTask(TaskDTO taskDTO) {
        taskService.save(taskDTO);
        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}")
    public String getTask(@PathVariable("id") String id) {
        taskService.deleteById(id);
        return "redirect:/task/create";
    }
}
