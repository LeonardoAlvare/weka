package com.importweka.weka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.importweka.weka.services.DatasetService;
import com.importweka.weka.services.dto.DatasetDTO;
import com.importweka.weka.services.dto.DatasetResponseDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/prediccion")
public class DatasetController {

    @Autowired
    private DatasetService service;

    @PostMapping("/realizar-prediccion")
    public DatasetResponseDTO prediccion(@RequestBody DatasetDTO dataset) throws Exception {
        return service.prediccion(dataset);
    }
}
