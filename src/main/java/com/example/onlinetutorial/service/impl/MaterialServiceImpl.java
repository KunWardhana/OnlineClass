package com.example.onlinetutorial.service.impl;

import com.example.onlinetutorial.io.entity.ClassEntity;
import com.example.onlinetutorial.io.entity.Header_MaterialEntity;
import com.example.onlinetutorial.io.entity.MaterialEntity;
import com.example.onlinetutorial.io.entity.UserEntity;
import com.example.onlinetutorial.io.repository.ClassRepository;
import com.example.onlinetutorial.io.repository.Header_MaterialRepository;
import com.example.onlinetutorial.io.repository.MaterialRepository;
import com.example.onlinetutorial.service.iservice.IMaterialService;
import com.example.onlinetutorial.shared.dto.ClassDTO;
import com.example.onlinetutorial.shared.dto.Header_MaterialDTO;
import com.example.onlinetutorial.shared.dto.MaterialDTO;
import com.example.onlinetutorial.shared.dto.UserDTO;
import com.example.onlinetutorial.shared.utils.GenerateRandomPublicId;
import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MaterialServiceImpl implements IMaterialService {
    @Autowired
    ClassRepository classRepository;
    @Autowired
    MaterialRepository materialRepository;
    @Autowired
    Header_MaterialRepository headerRepository;
    @Autowired
    GenerateRandomPublicId generateRandomPublicId;

    @Override
    public MaterialDTO addNewMaterial(String classid, MaterialDTO materialDTO) {
        ModelMapper mapper = new ModelMapper();

        materialDTO.setMaterialid(generateRandomPublicId.generateUserId( 30));
        ClassEntity classdata = classRepository.findByClassid(classid);

        Header_MaterialDTO headerMaterialDTO = new Header_MaterialDTO();
        Header_MaterialEntity headerMaterialEntity = new Header_MaterialEntity();

        materialDTO.setClassEntities(Arrays.asList(mapper.map(classdata, ClassDTO.class)));
        MaterialEntity entity = mapper.map(materialDTO, MaterialEntity.class);

        MaterialEntity storedata = materialRepository.save(entity);
        headerMaterialEntity.setMaterialEntity(storedata);
        headerMaterialEntity.setClasscol(classdata);

        Header_MaterialEntity storedValue = headerRepository.save(headerMaterialEntity);
        return mapper.map(storedata, MaterialDTO.class);
    }

    @Override
    public List<MaterialDTO> getAllMaterial() {
        ModelMapper mapper = new ModelMapper();
        List<MaterialEntity> materialEntities = materialRepository.findAll();
        List<MaterialDTO> returnval = new ArrayList<>();

        for (MaterialEntity entity: materialEntities)
        {
            returnval.add(mapper.map(entity, MaterialDTO.class));
        }

        return returnval;
    }

    @Override
    public MaterialDTO findMaterialByMaterialId(String materialid) {
        MaterialEntity entity = materialRepository.findByMaterialid(materialid);
        return new ModelMapper().map(entity, MaterialDTO.class);
    }

    @Override
    public MaterialDTO findMaterialByClassAndMaterialID(String classid, String materialid) {
        MaterialEntity materialEntity = materialRepository.findByMaterialid(materialid);
        ClassEntity classEntity = classRepository.findByClassid(classid);
        Header_MaterialEntity headerMaterialEntity =
                headerRepository.findByClasscolAndAndMaterialEntity(classEntity, materialEntity);

        if(headerMaterialEntity == null || materialEntity.isDeleted()==true)
        {
            return null;
        }
        return new ModelMapper().map(materialEntity, MaterialDTO.class);
    }

    @Override
    public MaterialDTO deleteMaterial(String materialid) {
        MaterialEntity entity = materialRepository.findByMaterialid(materialid);
        entity.setDeleted(true);
        MaterialEntity stored = materialRepository.save(entity);
        return new ModelMapper().map(stored, MaterialDTO.class);
    }
}
