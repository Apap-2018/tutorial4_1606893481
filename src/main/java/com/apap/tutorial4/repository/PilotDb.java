package com.apap.tutorial4.repository;

import com.apap.tutorial4.model.PilotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by esak on 10/3/2018.
 */

@Repository
public interface PilotDb extends JpaRepository<PilotModel, Long> {
    PilotModel findByLicenseNumber(String licenseNumber);

    @Modifying
    @Transactional
    void deleteByLicenseNumber(String licenseNumber);

    @Modifying
    @Transactional
    PilotModel save(PilotModel pilot);


}
