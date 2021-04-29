package com.example.onlinetutorial.ui.controller;

import com.example.onlinetutorial.service.iservice.IMaterialService;
import com.example.onlinetutorial.shared.dto.ClassDTO;
import com.example.onlinetutorial.shared.dto.MaterialDTO;
import com.example.onlinetutorial.shared.dto.UserDTO;
import com.example.onlinetutorial.ui.model.request.MaterialRequest;
import com.example.onlinetutorial.ui.model.response.ClassResponse;
import com.example.onlinetutorial.ui.model.response.MaterialResponse;
import com.example.onlinetutorial.ui.model.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/material")
public class MaterialController {

    @Autowired
    IMaterialService iMaterialService;

    @PostMapping(path = "/{classid}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public MaterialResponse addNewMaterial(@PathVariable String classid, @RequestBody MaterialRequest materialRequest){
        ModelMapper mapper = new ModelMapper();

        MaterialDTO materialDTOO = mapper.map(materialRequest, MaterialDTO.class);
        MaterialDTO createMaterial = iMaterialService.addNewMaterial(classid, materialDTOO);
        return mapper.map(createMaterial, MaterialResponse.class);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<MaterialResponse> getAllMaterial(){
        ModelMapper mapper = new ModelMapper();
        List<MaterialDTO>  dtoList = iMaterialService.getAllMaterial();
        List<MaterialResponse> returngwbre = new ArrayList<>();

        for (MaterialDTO dto: dtoList) {
            returngwbre.add(mapper
                    .map(dto, MaterialResponse.class));
        }

        return returngwbre;
    }

    @GetMapping(path = "/{materialid}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public MaterialResponse getMaterialById(@PathVariable String materialid){
        MaterialDTO response = iMaterialService.findMaterialByMaterialId(materialid);
        return new ModelMapper().map(response, MaterialResponse.class);
    }

    @GetMapping(path = "/{classid}/{materialid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public MaterialResponse getMaterialOnClass(@PathVariable String classid, @PathVariable String materialid){
        ModelMapper mapper = new ModelMapper();
        MaterialDTO response = iMaterialService.findMaterialByClassAndMaterialID(classid, materialid);

        if(response == null)
        {
            return null;
        }
        return mapper.map(response, MaterialResponse.class);
    }

    @DeleteMapping(path = "/{materialid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public MaterialResponse deleteMaterial(@PathVariable String materialid){
        MaterialDTO materialDTO = iMaterialService.deleteMaterial(materialid);

        return new ModelMapper().map(materialDTO, MaterialResponse.class);
    }

}
