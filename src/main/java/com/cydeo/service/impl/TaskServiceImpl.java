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
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {

    private static long idCounter = 3;

    @Override
    public TaskDTO save(TaskDTO object) {
        if(object.getStatus()==null){
            object.setAssignedDate(LocalDate.now());
            object.setStatus(Status.OPEN);
            object.setId(idCounter++);
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
        TaskDTO taskDTO= findById(object.getId());
        if (object.getId() == null) {
            object.setStatus(taskDTO.getStatus());
            object.setId(taskDTO.getId());
        }
        super.updateById(object.getId(), object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
