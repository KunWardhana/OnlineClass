package com.example.onlinetutorial.ui.controller;

import com.example.onlinetutorial.service.iservice.IUserService;
import com.example.onlinetutorial.shared.dto.UserDTO;
import com.example.onlinetutorial.ui.model.request.UserRequest;
import com.example.onlinetutorial.ui.model.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

//    @GetMapping(path = "/testKoneksi", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public String test()
//    {
//        return "No Problem, rest api is running";
//    }


    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserResponse> getUsers()
    {
        ModelMapper mapper = new ModelMapper();
        List<UserDTO> listDTO = userService.getAllUsers();
        List<UserResponse> returnValue = new ArrayList<>();

        for (UserDTO dto : listDTO)
        {
            returnValue.add(mapper.map(dto, UserResponse.class));
        }

        return returnValue;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse addUsers(@RequestBody UserRequest userRequest)
    {
        ModelMapper mapper = new ModelMapper();
        UserDTO requestDTO = mapper.map(userRequest, UserDTO.class);

        UserDTO responseDTO = userService.addNewUser(requestDTO);

        return mapper.map(responseDTO, UserResponse.class);
    }


}
