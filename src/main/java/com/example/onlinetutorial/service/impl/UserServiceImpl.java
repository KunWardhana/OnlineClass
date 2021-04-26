package com.example.onlinetutorial.service.impl;

import com.example.onlinetutorial.io.entity.UserEntity;
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

    public UserServiceImpl(UserRepository userRepository, GenerateRandomPublicId randomPublicId) {
        this.userRepository = userRepository;
        this.randomPublicId = randomPublicId;
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
}
