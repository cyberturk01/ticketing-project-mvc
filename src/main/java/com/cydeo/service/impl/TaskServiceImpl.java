package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {

    @Override
    public TaskDTO save(TaskDTO object) {
        if (object.getTaskStatus() == null) {
            object.setTaskStatus(Status.OPEN);
        }

        if (object.getAssignedDate() == null) {
            object.setAssignedDate(LocalDate.now());
        }

        if (object.getId() == null) {
            object.setId(UUID.randomUUID().getMostSignificantBits());
        }
        return super.save(object.getId(), object);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findAll() {

        return super.findAll();
    }

    @Override
    public void update(TaskDTO object) {
        TaskDTO taskDTO = findById(object.getId());

        object.setTaskStatus(taskDTO.getTaskStatus());
        object.setId(taskDTO.getId());
        object.setAssignedDate(taskDTO.getAssignedDate());

        super.updateById(object.getId(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public List<TaskDTO> findTaskByManager(UserDTO manager) {
        return super.findAll().stream().filter(task->task.getAssignedEmployee().equals(manager)).collect(Collectors.toList());
    }
    @Override
    public List<TaskDTO> findAllTasksByStatus(Status status) {
        return findAll().stream().filter(task -> task.getTaskStatus().equals(Status.COMPLETE)).collect(Collectors.toList());
    }

    @Override
    public List<TaskDTO> findAllTasksByStatusIsNot(Status status) {
        return findAll().stream().filter(task -> !task.getTaskStatus().equals(Status.COMPLETE)).collect(Collectors.toList());
    }

    @Override
    public void updateStatus(TaskDTO task) {
        findById(task.getId()).setTaskStatus(task.getTaskStatus());
        update(task);
    }
}
