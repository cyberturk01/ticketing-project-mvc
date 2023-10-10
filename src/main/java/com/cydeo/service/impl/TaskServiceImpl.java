package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, String> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO object) {
        return super.save(object.getTaskSubject(), object);
    }

    @Override
    public TaskDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findAll() {

        return super.findAll();
    }

    @Override
    public void update(TaskDTO object) {
        super.updateById(object.getTaskSubject(), object);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }
}
