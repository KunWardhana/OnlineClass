package com.example.onlinetutorial.ui.controller;

import com.example.onlinetutorial.service.iservice.IUserService;
import com.example.onlinetutorial.shared.dto.UserDTO;
import com.example.onlinetutorial.ui.model.request.UserRequest;
import com.example.onlinetutorial.ui.model.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/testKoneksi", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String test()
    {
        return "No Problem, rest api is running";
    }


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

    @GetMapping(path = "/userId", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse findUserByUserId(@PathVariable String userId)
    {
        UserDTO response = userService.findUserByUserId(userId);
        return new ModelMapper().map(response, UserResponse.class);
    }

    @PutMapping(path = "/userId", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse updateUserByUserId(@PathVariable String userId, @RequestBody UserRequest request)
    {
        ModelMapper mapper = new ModelMapper();
        UserDTO requestDTO = mapper.map(request, UserDTO.class);
        UserDTO responseDTO = userService.updateUserByUserId(userId, requestDTO);

        return mapper.map(responseDTO, UserResponse.class);
    }

    @PutMapping(path = "/{userId}/{classId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse changeUserClass (@PathVariable String userId, @PathVariable String classId)
    {
        UserDTO dto = userService.changeUserClass(userId, classId);
        return new ModelMapper().map(dto, UserResponse.class);
    }

    @GetMapping(path = "/{classId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserResponse> getAllUserinClass (String classId)
    {
        ModelMapper mapper = new ModelMapper();
        List<UserDTO> dtoList = userService.getAllUsersinClass(classId);
        List<UserResponse> responseList = new ArrayList<>();

        for (UserDTO dto : dtoList)
        {
            responseList.add(mapper.map(dtoList, UserResponse.class));
        }

        return responseList;
    }

    @DeleteMapping(path = "/DeleteClass/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse deleteClassUser(@PathVariable String userId)
    {
        UserDTO dto = userService.deleteClassUser(userId);
        return new ModelMapper().map(dto, UserResponse.class);
    }


}
