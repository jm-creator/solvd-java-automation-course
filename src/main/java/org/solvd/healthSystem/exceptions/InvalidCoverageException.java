package org.solvd.healthSystem.exceptions;

public class InvalidCoverageException extends Exception {
    public InvalidCoverageException() {
        super("this patient doesn't have coverage");
    }
}
