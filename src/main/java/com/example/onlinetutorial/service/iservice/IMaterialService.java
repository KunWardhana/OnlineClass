package com.example.onlinetutorial.service.iservice;

import com.example.onlinetutorial.shared.dto.MaterialDTO;

import java.util.List;

public interface IMaterialService {
    MaterialDTO addNewMaterial(String classid, MaterialDTO materialDTO);

    List<MaterialDTO> getAllMaterial();

    MaterialDTO findMaterialByMaterialId(String materialid);

    MaterialDTO findMaterialByClassAndMaterialID(String classid, String materialid);

    MaterialDTO deleteMaterial(String materialid);
}
