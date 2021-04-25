package com.example.onlinetutorial.ui.controller;

import com.example.onlinetutorial.service.impl.ClassServiceImpl;
import com.example.onlinetutorial.shared.dto.ClassDTO;
import com.example.onlinetutorial.ui.model.request.ClassRequest;
import com.example.onlinetutorial.ui.model.response.ClassResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



        return null;
    }



}
