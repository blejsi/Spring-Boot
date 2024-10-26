package com.footballApp.FootballApp.controller;

import com.footballApp.FootballApp.exseption.ResourceNotFoundException;
import com.footballApp.FootballApp.model.Trainner;
import com.footballApp.FootballApp.repository.TrainnerRepository;
import com.footballApp.FootballApp.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class TrainerController {


    private final TrainerService trainerService;


     @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }


    @GetMapping
    public List<Trainner> getAllTrainers() {

        return trainerService.getAllTrainers();
    }

    @PostMapping
    public Trainner createEmployee(@RequestBody Trainner trainner) {

        return trainerService.createEmployee(trainner);
    }

    @GetMapping("{id}")
    public ResponseEntity<Trainner> getTrainerById(@PathVariable Long id) {
     return getTrainerById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Trainner> updateEmployee(@PathVariable Long id, @RequestBody Trainner trainerDetails) {


        return trainerService.updateTrainer(id, trainerDetails);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteTrainer(@PathVariable Long id) {

         return  deleteTrainer(id);
    }

    @GetMapping
    public ResponseEntity<Trainner> getMaxSalary(@PathVariable Long id) {
         return getMaxSalary(id);
    }


}