package com.example.onlinetutorial.service.iservice;

import com.example.onlinetutorial.shared.dto.ClassDTO;

import java.util.List;

public interface IClassService {

    ClassDTO addNewDClass(ClassDTO classDTO);

    List<ClassDTO> getAllClass();

    ClassDTO findClassByClassID(String classid);

    ClassDTO updateClassByClassID(String classid, ClassDTO requestDTO);
}
