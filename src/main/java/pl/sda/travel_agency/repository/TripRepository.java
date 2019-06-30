package pl.sda.travel_agency.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import pl.sda.travel_agency.model.Trip;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long>{
    @Override
    List<Trip> findAll();


}
