package com.solvd.healthsystem.exceptions;

public class IncorrectPermissionsException extends  Exception{
    public IncorrectPermissionsException() {
        super("That employee doesn't have permissions");
    }
}
