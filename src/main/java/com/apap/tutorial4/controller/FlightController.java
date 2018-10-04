package com.apap.tutorial4.controller;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.service.FlightService;
import com.apap.tutorial4.service.PilotService;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by esak on 10/4/2018.
 */

@Controller
public class FlightController {
    @Autowired
    private FlightService flightService;

    @Autowired
    private PilotService pilotService;

    @RequestMapping(value = "/flight/add/{licenseNumber}", method = RequestMethod.GET)
    private String add(@PathVariable(value = "licenseNumber") String licenseNumber, Model model) {
        FlightModel flight = new FlightModel();
        PilotModel pilot = pilotService.getPilotDataByLicenseNumber(licenseNumber);
        flight.setPilot(pilot);

        model.addAttribute("flight", flight);
        return "addFlight";
    }

    @RequestMapping(value = "/flight/add", method = RequestMethod.POST)
    private String addFlightSubmit(@ModelAttribute FlightModel flight) {
        flightService.addFlight(flight);
        return "add";
    }

    @RequestMapping(value = "/flight/delete/{flightNumber}", method = RequestMethod.GET)
    private String delete(@PathVariable(value="flightNumber") String flightNumber) {
        flightService.removeFlight(flightNumber);

        return "delete";
    }

    @RequestMapping(value="/flight/update/{flightNumber}", method = RequestMethod.GET)
    private String updateFlight(@PathVariable(value="flightNumber") String flightNumber, Model model) {
        FlightModel flight = flightService.getDataByFlightNumber(flightNumber);

        model.addAttribute("flight",flight);

        return "updateFlight";
    }

    @RequestMapping(value = "/flight/update", method = RequestMethod.POST)
    private String updateFlightSubmit(@ModelAttribute FlightModel flight) {
        flightService.updateFlight(flight);
        return "update";
    }

    @RequestMapping("/flight/view")
    private String viewFlight(@RequestParam("flightNumber") String flightNumber, Model model){
        List<FlightModel> allFlights = flightService.getFlightList();
        ArrayList<FlightModel> flights = new ArrayList<FlightModel>() {
        };
        for (FlightModel flight : allFlights) {
            if(flight.getFlightNumber().equals(flightNumber))
                flights.add(flight);
        }
        model.addAttribute("flights",flights);

        return "view-flight";
    }
}
