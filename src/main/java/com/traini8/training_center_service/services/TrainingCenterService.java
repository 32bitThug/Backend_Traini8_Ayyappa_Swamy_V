package com.traini8.training_center_service.services;

import com.traini8.training_center_service.entities.TrainingCenter;
import com.traini8.training_center_service.repository.TrainingCenterRepository;
import com.traini8.training_center_service.specifications.TrainingCenterSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingCenterService {

    @Autowired
    public TrainingCenterRepository repository;

    public TrainingCenter addTrainingCenter(TrainingCenter trainingCenter) {
        return repository.save(trainingCenter);
    }
    public List<TrainingCenter> getTrainingCenters () {
        return repository.findAll();
    }

    public List<TrainingCenter> getFilteredTrainingCenters(String city, String state, String course) {
        if ((city == null || city.isEmpty()) && (state == null || state.isEmpty()) && (course == null || course.isEmpty())) {
            return new ArrayList<>();
        }
        return repository.findAll(TrainingCenterSpecifications.filterTrainingCenters(city, state, course));
    }
}
