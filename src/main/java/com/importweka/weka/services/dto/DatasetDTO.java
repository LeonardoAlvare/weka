package com.importweka.weka.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatasetDTO {
    // private String nombre;
    private int edad;
    private int yearsExperience;
    private String educationLevel; // 0: Bachiller, 1: Semi-técnico, 2: Tecnólogo, 3: Profesional
    private String languages; // 1: Español, 2: Inglés, 3: Ambos
    private String workAvailability; // 0: Tiempo completo, 1: Medio tiempo
    private String category; // 0: Web, 1: Mobile, 2: Backend, 3: Fullstack
    private String developerLevel; // 0: Junior, 1: Semi-Senior, 2: Senior
    private int paymentProposal;
    private int estimatedTime;
    private String categoryProject; // 0: Web, 1: Mobile, 2: Backend, 3: Fullstack
}
