package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final UserService userService;
    private final ProjectService projectService;


    public ProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping("/create")
    public String createProject(Model model){
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());

        return "/project/create";
    }
    @PostMapping("/create")
    public String createProject(ProjectDTO projectDTO){

        projectService.save(projectDTO);
        return "redirect:/project/create";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable("id") String id){
        projectService.deleteById(id);
        return "redirect:/project/create";
    }
    @GetMapping("/update/{id}")
    public String editProject(@PathVariable("id") String id, Model model){
        model.addAttribute("project", projectService.findById(id));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());

        return "/project/update";
    }
    @PostMapping("/update")
    public String updateProject(ProjectDTO project){
        projectService.update(project);
        return "redirect:/project/create";
    }

    @GetMapping("/complete/{id}")
    public String completeProject(@PathVariable("id") String id){

        projectService.complete(projectService.findById(id));
        return "redirect:/project/create";
    }
    @GetMapping("/manager/project-status")
    public String getProjectStatus(Model model){
        UserDTO manager=userService.findById("john@yigit.org");

        List<ProjectDTO> projects= projectService.getCountedProjectsOfManager(manager);
        model.addAttribute("projects", projects);
        return "/manager/project-status";
    }
    @GetMapping("/manager/complete/{projectCode}")
    public String managerCompleteProject(@PathVariable("projectCode") String projectCode) {
        projectService.complete(projectService.findById(projectCode));
        return "redirect:/project/manager/project-status";
    }

}
