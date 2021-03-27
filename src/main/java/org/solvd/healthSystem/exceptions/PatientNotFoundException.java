package org.solvd.healthSystem.exceptions;

public class PatientNotFoundException extends Exception {
    public PatientNotFoundException() {
        super("Patient not found");
    }
}
