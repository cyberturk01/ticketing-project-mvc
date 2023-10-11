package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, String> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO object) {
        if(object.getStatus()==null){
            object.setAssignedDate(LocalDate.now());
            object.setStatus(Status.OPEN);
        }
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
        TaskDTO taskDTO= findById(object.getTaskSubject());
        if (object.getStatus() == null) {
            object.setStatus(taskDTO.getStatus());
        }
        super.updateById(object.getTaskSubject(), object);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }
}
