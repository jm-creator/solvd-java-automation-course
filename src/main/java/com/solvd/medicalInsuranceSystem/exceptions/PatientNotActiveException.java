package com.solvd.medicalInsuranceSystem.exceptions;

public class PatientNotActiveException extends  Exception {
    public PatientNotActiveException() {
        super("This patient is not active.");
    }
}
