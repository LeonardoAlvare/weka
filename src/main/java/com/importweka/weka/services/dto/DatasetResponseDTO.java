package com.importweka.weka.services.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DatasetResponseDTO {
    private String prediccion;
    private Map<String, Double> probabilidades;
}
