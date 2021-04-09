package com.solvd.medicalInsuranceSystem.exceptions;

public class InvalidCoverageException extends Exception {
    public InvalidCoverageException() {
        super("this patient doesn't have coverage");
    }
}
