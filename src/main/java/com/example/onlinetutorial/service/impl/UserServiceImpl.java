package com.example.onlinetutorial.service.impl;

import com.example.onlinetutorial.io.entity.ClassEntity;
import com.example.onlinetutorial.io.entity.UserEntity;
import com.example.onlinetutorial.io.repository.ClassRepository;
import com.example.onlinetutorial.io.repository.UserRepository;
import com.example.onlinetutorial.service.iservice.IUserService;
import com.example.onlinetutorial.shared.dto.UserDTO;
import com.example.onlinetutorial.shared.utils.GenerateRandomPublicId;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final GenerateRandomPublicId randomPublicId;
    private final ClassRepository classRepository;

    public UserServiceImpl(UserRepository userRepository, GenerateRandomPublicId randomPublicId, ClassRepository classRepository) {
        this.userRepository = userRepository;
        this.randomPublicId = randomPublicId;
        this.classRepository = classRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {

        ModelMapper mapper = new ModelMapper();
        List<UserEntity> listEntity = userRepository.findAll();
        List<UserDTO> returnValue = new ArrayList<>();

        for (UserEntity entity : listEntity)
        {
            returnValue.add(mapper.map(entity, UserDTO.class));
        }

        return returnValue;
    }

    @Override
    public UserDTO addNewUser(UserDTO requestDTO) {

        requestDTO.setUserid(randomPublicId.generateUserId(35));

        ModelMapper mapper = new ModelMapper();
        UserEntity newUser = userRepository.save(mapper.map(requestDTO, UserEntity.class));

        return mapper.map(newUser, UserDTO.class);
    }

    @Override
    public UserDTO findUserByUserId(String userId) {

        UserEntity entity = userRepository.findByUserid(userId);
        return new ModelMapper().map(entity, UserDTO.class);
    }

    @Override
    public UserDTO updateUserByUserId(String userId, UserDTO dtoRequest) {

        UserEntity entity = userRepository.findByUserid(userId);

        entity.setUsername(dtoRequest.getUsername());
        entity.setPassword(dtoRequest.getPassword());
        entity.setEmail(dtoRequest.getEmail());
        entity.setPhonenumber(dtoRequest.getPhonenumber());
        entity.setRole(dtoRequest.getRole());

        UserEntity storedEntity = userRepository.save(entity);

        return new ModelMapper().map(storedEntity, UserDTO.class);
    }

    @Override
    public UserDTO changeUserClass(String userId, String classId) {

        UserEntity entity = userRepository.findByUserid(userId);
        ClassEntity classEntity = classRepository.findByClassid(classId);

        entity.setClassEntity(classEntity);
        UserEntity storedEntity = userRepository.save(entity);

        return new ModelMapper().map(storedEntity, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsersinClass(String classId) {

        ClassEntity classEntity = classRepository.findByClassid(classId);
        List<UserEntity> userEntities = userRepository.findAllByClassEntity(classEntity);
        ModelMapper mapper = new ModelMapper();
        List<UserDTO> returnValue = new ArrayList<>();

        for (UserEntity entity : userEntities)
        {
            returnValue.add(mapper.map(entity, UserDTO.class));
        }

        return returnValue;
    }

    @Override
    public UserDTO deleteClassUser(String userId) {

        UserEntity entity = userRepository.findByUserid(userId);
        entity.setClassEntity(null);

        UserEntity stored = userRepository.save(entity);

        return new ModelMapper().map(stored, UserDTO.class);
    }
}
