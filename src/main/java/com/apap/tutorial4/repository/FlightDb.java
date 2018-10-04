package com.apap.tutorial4.repository;

import com.apap.tutorial4.model.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by esak on 10/3/2018.
 */

@Repository
public interface FlightDb extends JpaRepository<FlightModel, Long> {
    FlightModel findByFlightNumber(String flightNumber);

    @Modifying
    @Transactional
    void deleteByFlightNumber(String flightNumber);

    @Modifying
    @Transactional
    FlightModel save(FlightModel flight);

    @Override
    List<FlightModel> findAll();
}
