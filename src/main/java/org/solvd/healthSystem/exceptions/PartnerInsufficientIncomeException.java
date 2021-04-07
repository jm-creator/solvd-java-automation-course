package org.solvd.healthSystem.exceptions;

public class PartnerInsufficientIncomeException extends Exception {
    public PartnerInsufficientIncomeException() {
        super("Patient doesn't meet the income restriction");
    }
}
