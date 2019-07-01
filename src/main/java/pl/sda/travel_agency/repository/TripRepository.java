package pl.sda.travel_agency.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.sda.travel_agency.model.*;


import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import pl.sda.travel_agency.model.Trip;


import java.util.List;
import java.util.Optional;


@Repository
public interface TripRepository extends JpaRepository<Trip, Long>{
    @Override
    List<Trip> findAll();
    Trip findByTripId(Long tripId);



}
