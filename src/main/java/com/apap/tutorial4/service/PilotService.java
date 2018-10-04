package com.apap.tutorial4.service;

import com.apap.tutorial4.model.PilotModel;

/**
 * Created by esak on 10/3/2018.
 */
public interface PilotService {
    PilotModel getPilotDataByLicenseNumber(String licenseNumber);

    void addPilot(PilotModel pilot);

    void removePilot(String licenseNumber);

    void updatePilot(PilotModel pilot);

}
