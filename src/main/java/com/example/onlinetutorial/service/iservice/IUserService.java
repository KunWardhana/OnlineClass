package com.example.onlinetutorial.service.iservice;


import com.example.onlinetutorial.shared.dto.UserDTO;

import java.util.List;

public interface IUserService {

    List<UserDTO> getAllUsers();

    UserDTO addNewUser(UserDTO requestDTO);

    UserDTO findUserByUserId(String userId);

    UserDTO updateUserByUserId (String userId, UserDTO dtoRequest);

    UserDTO changeUserClass (String userId, String classId);

    List<UserDTO> getAllUsersinClass(String classId);

    UserDTO deleteClassUser (String userId);

}
