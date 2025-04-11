package com.importweka.weka.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatasetDTO {
    private String status_x; // aceptado o rechazado
    private String requiredExperience; // junior, semi-senior, senior
    private String proposalsReceived; // alto, bajo, medio
    private String popularidadCreator; // alto, bajo, medio
    private String category; // backend, frontend, mobile, nube, web
    private String academicTraining; // backend, frontend, mobile, nube, web
}
