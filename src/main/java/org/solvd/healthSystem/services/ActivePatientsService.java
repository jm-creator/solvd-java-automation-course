package org.solvd.healthSystem.services;

import org.solvd.healthSystem.entity.App;
import org.solvd.healthSystem.entity.Patient;
import org.solvd.healthSystem.interfaces.IActivePatients;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ActivePatientsService implements IActivePatients {
    private final List<Patient> patients = App.getRandomPatients();
    @Override
    public List<Patient> filterByActiveUser() {
        List<Patient> patientList = new ArrayList<>();




      for (Patient patient : patients) {
               if (patient.isActive()) {
                   patientList.add(patient);
               }
        }
       return patientList;
    }
}
