package com.example.onlinetutorial.service.impl;

import com.example.onlinetutorial.io.entity.ClassEntity;
import com.example.onlinetutorial.io.repository.ClassRepository;
import com.example.onlinetutorial.service.iservice.IClassService;
import com.example.onlinetutorial.shared.dto.ClassDTO;
import com.example.onlinetutorial.shared.utils.GenerateRandomPublicId;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassServiceImpl implements IClassService {

    private final ClassRepository classRepository;
    private final GenerateRandomPublicId randomPublicId;

    public ClassServiceImpl(ClassRepository classRepository, GenerateRandomPublicId randomPublicId) {
        this.classRepository = classRepository;
        this.randomPublicId = randomPublicId;
    }

    @Override
    public ClassDTO addNewDClass(ClassDTO classDTO) {
        classDTO.setClassid(randomPublicId.generateUserId(35));
        ModelMapper mapper = new ModelMapper();
        ClassEntity classEntity = classRepository.save(mapper.map(classDTO, ClassEntity.class));


        return mapper.map(classEntity, ClassDTO.class);
    }

    @Override
    public List<ClassDTO> getAllClass() {
        ModelMapper mapper = new ModelMapper();
        List<ClassEntity> classEntityList = classRepository.findAll();
        List<ClassDTO> returnval = new ArrayList<>();

        for (ClassEntity entity: classEntityList)
        {
            returnval.add(mapper.map(entity, ClassDTO.class));
        }

        return returnval;
    }
}