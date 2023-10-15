package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO, String> implements UserService {
    @Override
    public UserDTO save(UserDTO object) {
        return super.save(object.getEmail(), object);
    }

    @Override
    public UserDTO findById(String s) {
        return super.findById(s);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String s) {
        super.deleteById(s);
    }

    @Override
    public void update(UserDTO object) {
        super.updateById(object.getEmail(), object);
    }

    @Override
    public List<UserDTO> findManagers() {
        return findAll().stream().filter(a -> a.getRole().getId() == 2).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findEmployees() {
        return findAll().stream().filter(a -> a.getRole().getId() == 3).collect(Collectors.toList());
    }
}
