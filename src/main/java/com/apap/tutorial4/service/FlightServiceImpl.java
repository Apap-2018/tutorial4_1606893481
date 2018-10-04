package com.apap.tutorial4.service;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.repository.FlightDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by esak on 10/4/2018.
 */

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightDb flightDb;

    @Override
    public void addFlight(FlightModel flight) {
        flightDb.save(flight);
    }

    @Override
    public void removeFlight(String flightNumber) {
        flightDb.deleteByFlightNumber(flightNumber);
    }

    @Override
    public void updateFlight(FlightModel flight) {
        flightDb.save(flight);
    }

    @Override
    public FlightModel getDataByFlightNumber(String flightNumber) {
        return flightDb.findByFlightNumber(flightNumber);
    }

    @Override
    public List<FlightModel> getFlightList() {
        return flightDb.findAll();
    }


}
