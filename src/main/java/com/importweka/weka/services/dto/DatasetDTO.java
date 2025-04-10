package com.importweka.weka.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatasetDTO {
    private String userId_x;
    private String projectId;
    private String requiredExperience;
    private double proposalsReceived;
    private double popularidadCreator;
    private Boolean isFreelance;
    private String category;
    private double salary;
    private double timeLimit;
}
