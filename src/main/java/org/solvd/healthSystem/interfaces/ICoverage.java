package org.solvd.healthSystem.interfaces;

import org.solvd.healthSystem.exceptions.InvalidCoverageException;
import org.solvd.healthSystem.exceptions.PatientNotFoundException;

import java.util.List;

public interface ICoverage {
    boolean patientHasCoverage(String patientFirstName,  String coverageName) throws PatientNotFoundException, InvalidCoverageException;
    List<String> listHealCareCoverage(String patientName) throws PatientNotFoundException;
}
