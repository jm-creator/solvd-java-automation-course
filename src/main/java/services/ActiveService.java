package services;

import entity.App;
import entity.Patient;
import exceptions.PatientNotFoundException;
import interfaces.IActive;

import java.util.ArrayList;
import java.util.List;

public class ActiveService implements IActive {

    private final List<Patient> patients = App.getRandomPatients();


    @Override
    public boolean patientIsActive(String patientName) {
        for (Patient patient: patients) {
            if (patient.isActive())
                return true;
        }
        return false;
    }


}
