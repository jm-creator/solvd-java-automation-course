package org.solvd.healthSystem.interfaces;

import org.solvd.healthSystem.exceptions.PatientNotActiveException;

public interface IActive {
    boolean patientIsActive(String patientName) throws PatientNotActiveException;

}
