package com.footballApp.FootballApp.repository;

import com.footballApp.FootballApp.model.Trainner;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrainnerRepository extends JpaRepository<Trainner, Long> {


}
