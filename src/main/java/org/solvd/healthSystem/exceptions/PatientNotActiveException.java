package org.solvd.healthSystem.exceptions;

public class PatientNotActiveException extends  Exception {
    public PatientNotActiveException() {
        super("Error patient not found");
    }
}
