package com.importweka.weka.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatasetDTO {
    private double userId_x;
    private double projectId;
    private String requiredExperience;
    private String proposalsReceived;
    private String popularidadCreator;
    private Boolean isFreelance;
    private String category;
    private double salary;
    private double timeLimit;
}
