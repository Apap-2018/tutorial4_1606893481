package com.apap.tutorial4.service;

import com.apap.tutorial4.model.FlightModel;

import java.util.List;

/**
 * Created by esak on 10/3/2018.
 */
public interface FlightService {
    void addFlight(FlightModel flight);

    void removeFlight(String flightNumber);

    void updateFlight(FlightModel flight);

    FlightModel getDataByFlightNumber(String flightNumber);

    List<FlightModel> getFlightList();
}
