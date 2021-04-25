package com.example.onlinetutorial.service.iservice;


import com.example.onlinetutorial.shared.dto.UserDTO;

import java.util.List;

public interface IUserService {

    List<UserDTO> getAllUsers();

    UserDTO addNewUser(UserDTO requestDTO);

}