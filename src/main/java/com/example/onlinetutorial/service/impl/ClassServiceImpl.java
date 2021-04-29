package com.example.onlinetutorial.service.impl;

import com.example.onlinetutorial.io.entity.ClassEntity;
import com.example.onlinetutorial.io.entity.Header_MaterialEntity;
import com.example.onlinetutorial.io.entity.MaterialEntity;
import com.example.onlinetutorial.io.entity.UserEntity;
import com.example.onlinetutorial.io.repository.ClassRepository;
import com.example.onlinetutorial.io.repository.MaterialRepository;
import com.example.onlinetutorial.io.repository.UserRepository;
import com.example.onlinetutorial.service.iservice.IClassService;
import com.example.onlinetutorial.shared.dto.ClassDTO;
import com.example.onlinetutorial.io.repository.Header_MaterialRepository;
import com.example.onlinetutorial.shared.dto.Header_MaterialDTO;
import com.example.onlinetutorial.shared.dto.MaterialDTO;
import com.example.onlinetutorial.shared.dto.UserDTO;
import com.example.onlinetutorial.shared.utils.GenerateRandomPublicId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClassServiceImpl implements IClassService {

    @Autowired
    Header_MaterialRepository headerRepository;

    @Autowired
    MaterialRepository materialRepository;


    private final ClassRepository classRepository;
    private final GenerateRandomPublicId randomPublicId;
    private final UserRepository userRepository;

    public ClassServiceImpl(ClassRepository classRepository, GenerateRandomPublicId randomPublicId, UserRepository userRepository) {
        this.classRepository = classRepository;
        this.randomPublicId = randomPublicId;
        this.userRepository = userRepository;
    }

    @Override
    public ClassDTO addNewDClass(ClassDTO classDTO) {
        classDTO.setClassid(randomPublicId.generateUserId(35));
        ModelMapper mapper = new ModelMapper();
        Header_MaterialDTO headerMaterialDTO = new Header_MaterialDTO();


        ClassEntity classEntity = classRepository.save(mapper.map(classDTO, ClassEntity.class));
//        ClassEntity entity = mapper.map(classEntity, ClassEntity.class);
//        headerMaterialDTO.setMaterialEntity(mapper.map(entity, MaterialDTO.class));

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

    @Override
    public ClassDTO findClassByClassID(String classid) {
        ClassEntity entity = classRepository.findByClassid(classid);
        return new ModelMapper().map(entity, ClassDTO.class);
    }

    @Override
    public ClassDTO updateClassByClassID(String classid, ClassDTO requestDTO) {
        ClassEntity entity = classRepository.findByClassid(classid);

        entity.setClassname(requestDTO.getClassname());
        entity.setClassDateTime(requestDTO.getClassDateTime());

        ClassEntity storedEntity = classRepository.save(entity);

        return new ModelMapper().map(storedEntity, ClassDTO.class);
    }

    @Override
    public ClassDTO getUserClass(String userId) {

        UserEntity entity = userRepository.findByUserid(userId);
        ClassEntity classEntity = entity.getClassEntity();

        return new ModelMapper().map(classEntity, ClassDTO.class);
    }

    @Override
    public ClassDTO addMaterialToClass(String classid, String materialid) {
        ClassEntity entity = classRepository.findByClassid(classid);
        MaterialEntity materialEntity = materialRepository.findByMaterialid(materialid);
        Header_MaterialEntity headerMaterialEntity = new Header_MaterialEntity();

        headerMaterialEntity.setMaterialEntity(materialEntity);
        headerMaterialEntity.setClasscol(entity);

        headerRepository.save(headerMaterialEntity);

        return new ModelMapper().map(entity, ClassDTO.class);
    }

}
