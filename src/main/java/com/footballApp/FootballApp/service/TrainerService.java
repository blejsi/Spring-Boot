package com.footballApp.FootballApp.service;

import com.footballApp.FootballApp.exseption.ResourceNotFoundException;
import com.footballApp.FootballApp.model.Trainner;
import com.footballApp.FootballApp.repository.TrainnerRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    private final TrainnerRepository trainerRepository;

    public TrainerService(TrainnerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainner> getAllTrainers() {

        return trainerRepository.findAll();
    }

    public Trainner createEmployee(Trainner trainner) {

        return trainerRepository.save(trainner);
    }

    public Trainner getTrainerById(Long id) {
        return trainerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trainer not found"));
    }


    public ResponseEntity<Trainner> updateTrainer(Long id, Trainner trainnerDetails) {
        Trainner updateTrainer = trainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with Id: " + id));

        updateTrainer.setName(trainnerDetails.getName());
        updateTrainer.setSurname(trainnerDetails.getSurname());
        updateTrainer.setEmail(trainnerDetails.getEmail());
        updateTrainer.setSalary(trainnerDetails.getSalary());
        updateTrainer.setAge(trainnerDetails.getAge());
        updateTrainer.setTeam(trainnerDetails.getTeam());


        trainerRepository.save(updateTrainer);

        return ResponseEntity.ok(updateTrainer);
    }


    public ResponseEntity<HttpStatus> deleteTrainer(@PathVariable Long id) {
        Trainner employee = trainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with Id: " + id));

        trainerRepository.delete(employee);

        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }





}
