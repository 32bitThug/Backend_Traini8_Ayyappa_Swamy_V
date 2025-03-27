package com.traini8.training_center_service.repository;

import com.traini8.training_center_service.entities.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter,Long>, JpaSpecificationExecutor<TrainingCenter> {

}
