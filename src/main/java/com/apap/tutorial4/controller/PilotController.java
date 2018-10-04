package com.apap.tutorial4.controller;

import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by esak on 10/4/2018.
 */

@Controller
public class PilotController {
    @Autowired
    private PilotService pilotService;

    @RequestMapping("/")
    private String home() {
        return "home";
    }

    @RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
    private String add(Model model) {
        model.addAttribute("pilot", new PilotModel());
        return "addPilot";
    }

    @RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
    private String addPilotSubmit(@ModelAttribute PilotModel pilot) {
        pilotService.addPilot(pilot);
        return "add";
    }

    @RequestMapping("/pilot/view")
    private String viewPilot(@RequestParam("licenseNumber") String licenseNumber, Model model){
        PilotModel pilot = pilotService.getPilotDataByLicenseNumber(licenseNumber);
        model.addAttribute("pilot",pilot);

        return "view-pilot";
    }

    @RequestMapping(value="/pilot/delete/{licenseNumber}", method = RequestMethod.GET)
    private String deletePilot(@PathVariable(value="licenseNumber") String licenseNumber) {
        pilotService.removePilot(licenseNumber);

        return "delete";
    }

    @RequestMapping(value="/pilot/update/{licenseNumber}", method = RequestMethod.GET)
    private String updatePilot(@PathVariable(value="licenseNumber") String licenseNumber, Model model) {
        PilotModel pilot = pilotService.getPilotDataByLicenseNumber(licenseNumber);

        model.addAttribute("pilot",pilot);

        return "updatePilot";
    }

    @RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
    private String updatePilotSubmit(@ModelAttribute PilotModel pilot) {
        pilotService.updatePilot(pilot);
        return "update";
    }

}
