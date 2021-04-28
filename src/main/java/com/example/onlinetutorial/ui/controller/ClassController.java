package com.example.onlinetutorial.ui.controller;

import com.example.onlinetutorial.service.impl.ClassServiceImpl;
import com.example.onlinetutorial.shared.dto.ClassDTO;
import com.example.onlinetutorial.shared.dto.UserDTO;
import com.example.onlinetutorial.ui.model.request.ClassRequest;
import com.example.onlinetutorial.ui.model.request.UserRequest;
import com.example.onlinetutorial.ui.model.response.ClassResponse;
import com.example.onlinetutorial.ui.model.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/class")
public class ClassController {

    @Autowired
    ClassServiceImpl classService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ClassResponse addnewclass(@RequestBody ClassRequest clsrequest){
        ModelMapper mapper = new ModelMapper();

        ClassDTO classdto = mapper.map(clsrequest, ClassDTO.class);
        ClassDTO createdclass =classService.addNewDClass(classdto);

        return mapper.map(createdclass, ClassResponse.class);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ClassResponse> getAllClass(){
        ModelMapper mapper = new ModelMapper();
        List<ClassDTO>  dtoList = classService.getAllClass();
        List<ClassResponse> returngwbre = new ArrayList<>();

        for (ClassDTO dto: dtoList) {
            returngwbre.add(mapper
            .map(dto, ClassResponse.class));
        }

        return returngwbre;
    }

    @GetMapping(path = "/{classid}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ClassResponse findClassByClassID(@PathVariable String classid){
        ClassDTO response = classService.findClassByClassID(classid);
        return new ModelMapper().map(response, ClassResponse.class);
    }

    @PutMapping(path = "/{classid}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ClassResponse updateClassbyClassid(@PathVariable String classid, @RequestBody ClassRequest request){
        ModelMapper mapper = new ModelMapper();
        ClassDTO requestDTO = mapper.map(request, ClassDTO.class);
        ClassDTO responseDTO = classService.updateClassByClassID(classid, requestDTO);

        return mapper.map(responseDTO, ClassResponse.class);
    }

    @GetMapping(path = "/userId", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ClassResponse getUserClass(@PathVariable String userId)
    {
        ClassDTO classDTO = classService.getUserClass(userId);
        return new ModelMapper().map(classDTO, ClassResponse.class);
    }

}
