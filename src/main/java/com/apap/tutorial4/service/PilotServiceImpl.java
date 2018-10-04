package com.apap.tutorial4.service;

import com.apap.tutorial4.model.PilotModel;
import com.apap.tutorial4.repository.PilotDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by esak on 10/3/2018.
 */

@Service
@Transactional
public class PilotServiceImpl implements PilotService{
    @Autowired
    private PilotDb pilotDb;

    @Override
    public PilotModel getPilotDataByLicenseNumber(String licenseNumber) {
        return pilotDb.findByLicenseNumber(licenseNumber);
    }

    @Override
    public void addPilot(PilotModel pilot) {
        pilotDb.save(pilot);
    }

    @Override
    public void removePilot(String licenseNumber) {
        pilotDb.deleteByLicenseNumber(licenseNumber);
    }

    @Override
    public void updatePilot(PilotModel pilot) {
        pilotDb.save(pilot);
    }
}
