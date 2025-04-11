package com.importweka.weka.services;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.importweka.weka.services.dto.DatasetDTO;
import com.importweka.weka.services.dto.DatasetResponseDTO;

import jakarta.annotation.PostConstruct;
import weka.classifiers.Classifier;
import weka.core.DenseInstance;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;

@Service
public class DatasetService {

    private Classifier model;
    private Instances dataStructure;

    @PostConstruct
    public void init() throws Exception {
        InputStream modelStream = getClass().getClassLoader().getResourceAsStream("dataset_final.model");
        InputStream arffStream = getClass().getClassLoader().getResourceAsStream("dataset_final.arff");

        if (modelStream == null || arffStream == null) {
            throw new Exception("No se pudo cargar el modelo o la estructura ARFF");
        }

        model = (Classifier) weka.core.SerializationHelper.read(modelStream);
        dataStructure = new Instances(new java.io.BufferedReader(new java.io.InputStreamReader(arffStream)));
        // dataStructure.setClassIndex(dataStructure.numAttributes() - 1);
        dataStructure.setClassIndex(0);
    }

    public DatasetResponseDTO prediccion(DatasetDTO input) throws Exception {
        Instance instance = new DenseInstance(dataStructure.numAttributes());
        instance.setDataset(dataStructure);

        instance.setValue(dataStructure.attribute("requiredExperience"), input.getRequiredExperience());
        instance.setValue(dataStructure.attribute("proposalsReceived"), input.getProposalsReceived());
        instance.setValue(dataStructure.attribute("popularidadCreator"), input.getPopularidadCreator());
        instance.setValue(dataStructure.attribute("category"), input.getCategory());
        instance.setValue(dataStructure.attribute("academicTraining"), input.getAcademicTraining());

        double[] distribution = model.distributionForInstance(instance);
        Attribute classAttribute = dataStructure.classAttribute();

        Map<String, Double> probabilidades = new LinkedHashMap<>();
        String clasePredicha = "";
        double maxProb = -1;

        for (int i = 0; i < distribution.length; i++) {
            String className = classAttribute.value(i);
            double porcentaje = Math.round(distribution[i] * 10000.0) / 100.0; // 2 decimales
            probabilidades.put(className, porcentaje);

            if (distribution[i] > maxProb) {
                maxProb = distribution[i];
                clasePredicha = className;
            }
        }

        return new DatasetResponseDTO(clasePredicha, probabilidades);
    }
}
