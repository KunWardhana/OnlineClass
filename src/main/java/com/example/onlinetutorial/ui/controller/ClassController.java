package com.example.onlinetutorial.ui.controller;

import com.example.onlinetutorial.service.impl.ClassServiceImpl;
import com.example.onlinetutorial.shared.dto.ClassDTO;
import com.example.onlinetutorial.ui.model.request.ClassRequest;
import com.example.onlinetutorial.ui.model.response.ClassResponse;
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

    @GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
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



}
