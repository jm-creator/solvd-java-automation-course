package org.solvd.healthSystem.services;

import org.solvd.healthSystem.entity.App;
import org.solvd.healthSystem.entity.Patient;
import org.solvd.healthSystem.exceptions.PatientNotActiveException;
import org.solvd.healthSystem.interfaces.IActive;
import org.apache.log4j.Logger;

import java.util.List;

public class ActiveService implements IActive {
    private final static Logger LOGGER = Logger.getLogger(ActiveService.class);
    private final List<Patient> patients = App.getRandomPatients();


    @Override
    public boolean patientIsActive(String patientName) throws PatientNotActiveException {
        for (Patient patient: patients) {
            if (patient.isActive())
                return true;
            else
                throw new PatientNotActiveException();

        }
        return false;
    }


}
