package com.example.onlinetutorial.service.impl;

import com.example.onlinetutorial.service.iservice.IClassService;
import com.example.onlinetutorial.shared.dto.ClassDTO;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements IClassService {
    @Override
    public ClassDTO addNewDClass(ClassDTO classDTO) {
    classDTO.setId();

        return null;
    }
}
