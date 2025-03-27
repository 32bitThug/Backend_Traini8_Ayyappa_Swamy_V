package com.traini8.training_center_service.controller;

import com.traini8.training_center_service.entities.TrainingCenter;
import com.traini8.training_center_service.services.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/training-center")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService service;

    // get all training centers
    @GetMapping("/all")
    public ResponseEntity<List<TrainingCenter>> getTrainingCenters(){
        return ResponseEntity.ok(service.getTrainingCenters());
    }

    // post request to add a new training center
    @PostMapping
     public ResponseEntity< TrainingCenter> addTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter){
        return ResponseEntity.ok(service.addTrainingCenter(trainingCenter));
    }

    // get training center with filters on
    @GetMapping("/filter")
    public ResponseEntity<?> getFilteredTrainingCenters(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String course) {
        List<TrainingCenter> filteredCenters = service.getFilteredTrainingCenters(city, state, course);

        if (filteredCenters.isEmpty()) {
            return ResponseEntity.ok(Map.of("message", "No training centers found matching the filters."));
        }

        return ResponseEntity.ok(filteredCenters);
    }

}
